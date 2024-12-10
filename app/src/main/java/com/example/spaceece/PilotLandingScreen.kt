import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

@Composable
fun PilotLandingScreen() {
    var childName by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var childAge by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var profilePicture by remember { mutableStateOf<Bitmap?>(null) }

    val context = LocalContext.current
    val contentResolver = context.contentResolver

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                profilePicture = getBitmapFromUri(it, contentResolver)
            }
        }
    }

    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Profile Picture Section
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .clickable {
                        val intent = Intent(Intent.ACTION_PICK).apply {
                            type = "image/*"
                        }
                        launcher.launch(intent)
                    },
                contentAlignment = Alignment.Center
            ) {
                if (profilePicture != null) {
                    Image(
                        bitmap = profilePicture!!.asImageBitmap(),
                        contentDescription = "Profile Picture",
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Default Profile Picture",
                        tint = Color.Gray,
                        modifier = Modifier.size(80.dp)
                    )
                }
            }

            Text(
                text = "Child Details",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            OutlinedTextField(
                value = childName,
                onValueChange = { childName = it },
                label = { Text("Child's Name") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )

            OutlinedTextField(
                value = gender,
                onValueChange = { gender = it },
                label = { Text("Gender") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )

            OutlinedTextField(
                value = childAge,
                onValueChange = { childAge = it },
                label = { Text("Age") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )

            Button(
                onClick = { /* Open date picker if needed */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF9800)
                ),
            ) {
                Text(text = "Selected Date: $selectedDate")
            }

            Button(
                onClick = { /* Booking logic */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF9800),
                    contentColor = Color.White
                ),
            ) {
                Text("Book Now", fontSize = 18.sp)
            }
        }
    }
}

private fun getBitmapFromUri(uri: Uri, contentResolver: ContentResolver): Bitmap? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        val source = ImageDecoder.createSource(contentResolver, uri)
        ImageDecoder.decodeBitmap(source)
    } else {
        @Suppress("DEPRECATION")
        MediaStore.Images.Media.getBitmap(contentResolver, uri)
    }
}

@Preview
@Composable
fun PreviewPilotLandingScreen() {
    PilotLandingScreen()
}
