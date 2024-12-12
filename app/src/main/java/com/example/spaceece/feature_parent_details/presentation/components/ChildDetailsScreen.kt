package com.example.spaceece.feature_parent_details.presentation.components

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceece.R
import okio.IOException
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildDetailsScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        selectedImageUri = uri
        uri?.let {
            try {
                val inputStream = context.contentResolver.openInputStream(it)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                imageBitmap = bitmap.asImageBitmap()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    var childName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf<Date?>(null) }
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = modifier
                .padding(top = 30.dp)
            //.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Home Learning Made Easy",
            fontSize = 23.sp,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFFFA500))

        ) {
            Text(
                text = "Add the details of one of your\n children for enrollment",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                modifier = modifier
                    .align(Alignment.Center)
                    .padding(20.dp)
            )

        }
        Spacer(modifier = Modifier.height(40.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(horizontal = 10.dp)
            ) {

                Box(
                    modifier = modifier
                        .size(100.dp)
                        .border(3.dp, Color.Black, CircleShape)
                        .clip(CircleShape)
                        .background(Color(0xFFCBF5F1))
                        .clickable { launcher.launch("image/*") }
                ) {
                    imageBitmap?.let { bitmap ->
                        Image(
                            bitmap = bitmap,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = modifier.fillMaxSize()
                        )
                    } ?: run {
                        Image(
                            painter = painterResource(R.drawable.add_a_photo),
                            contentDescription = null,
                            modifier = modifier
                                .size(50.dp)
                                .align(Alignment.Center),
                        )
                    }

                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier.padding(start = 30.dp)
                ) {
                    Text(
                        text = "Child's Name",
                        fontSize = 13.sp,
                        style = MaterialTheme.typography.displayLarge,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Box(
                        modifier = Modifier
                            .size(width = 250.dp, height = 50.dp)
                            .clip(
                                RoundedCornerShape(
                                    10.dp
                                )
                            )
                            .background(Color(0xFFFFA500))
                            .border(
                                2.dp,
                                Color.Black,
                                RoundedCornerShape(
                                    10.dp
                                )
                            )
                    ) {
                        TextField(
                            value = childName,
                            onValueChange = {
                                childName = it
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                focusedTextColor = Color.Black,
                                containerColor = Color(0xFFFFA500)
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            singleLine = true,
                            modifier = modifier
                                .fillMaxWidth()
                                .background(Color(0xFFFFA500))
                        )
                    }
                    Spacer(modifier = modifier.height(20.dp))
                    Text(
                        text = "Child's Date of Birth",
                        fontSize = 13.sp,
                        style = MaterialTheme.typography.displayLarge,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Box(
                        modifier = Modifier
                            .size(width = 250.dp, height = 50.dp)
                            .clip(
                                RoundedCornerShape(
                                    10.dp
                                )
                            )
                            .background(Color(0xFFFFA500))
                            .border(
                                2.dp,
                                Color.Black,
                                RoundedCornerShape(
                                    10.dp
                                )
                            )
                    ) {

                        TextField(
                            value = birthDate,
                            onValueChange = {
                                birthDate = it
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                focusedTextColor = Color.Black,
                                containerColor = Color(0xFFFFA500)
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            singleLine = true,
                            modifier = modifier
                                .fillMaxWidth()
                                .background(Color(0xFFFFA500))
                        )

                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = null,
                            modifier = modifier
                                .align(Alignment.BottomEnd)
                                .size(40.dp)
                                .padding(end = 5.dp, bottom = 7.dp)
                                .clickable { }
                        )


                    }

                }
            }
        }
        Spacer(modifier = modifier.height(30.dp))
        ParentDetails()


    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(end = 10.dp, bottom = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(width = 150.dp, height = 60.dp)
                .clip(
                    RoundedCornerShape(30.dp)
                )
                .background(Color(0xFFFFA500))
                .border(
                    2.dp,
                    Color.Black,
                    RoundedCornerShape(30.dp)
                )
                .align(Alignment.BottomEnd)
                .clickable { }
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = "Confirm",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    modifier = modifier.padding(start = 10.dp, top = 4.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier
                            .size(15.dp)
                            .align(Alignment.Center)
                    )

                }


            }

        }
    }
}

@Composable
fun ParentDetails(

) {
    val text = "Fields with a \"*\" after them are mandatory"
    var applicantName by remember { mutableStateOf("") }
    var spouseName by remember { mutableStateOf("") }
    var applicantEmailId by remember { mutableStateOf("") }
    var applicantPhoneNumber by remember { mutableStateOf("") }
    var alternateNumber by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp)
    ) {
        Text(
            text = "Add your Details",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = text,
            fontSize = 15.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Applicant Name *",
            fontSize = 13.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .size(width = 350.dp, height = 55.dp)
                .clip(
                    RoundedCornerShape(
                        10.dp
                    )
                )
                .background(Color(0xFFFFA500))
                .border(
                    2.dp,
                    Color.Black,
                    RoundedCornerShape(
                        10.dp
                    )
                )
        ) {
            TextField(
                value = applicantName,
                onValueChange = {
                    applicantName = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                //.background(Color(0xFFFFA500))
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Spouse's Name",
            fontSize = 13.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .size(width = 350.dp, height = 55.dp)
                .clip(
                    RoundedCornerShape(
                        10.dp
                    )
                )
                .background(Color(0xFFFFA500))
                .border(
                    2.dp,
                    Color.Black,
                    RoundedCornerShape(
                        10.dp
                    )
                )
        ) {
            TextField(
                value = spouseName,
                onValueChange = {
                    spouseName = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                //.background(Color(0xFFFFA500))
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Applicant's Email ID",
            fontSize = 13.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .size(width = 350.dp, height = 55.dp)
                .clip(
                    RoundedCornerShape(
                        10.dp
                    )
                )
                .background(Color(0xFFFFA500))
                .border(
                    2.dp,
                    Color.Black,
                    RoundedCornerShape(
                        10.dp
                    )
                )
        ) {
            TextField(
                value = applicantEmailId,
                onValueChange = {
                    applicantEmailId = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                //.background(Color(0xFFFFA500))
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Applicant's Phone Number *",
            fontSize = 13.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .size(width = 350.dp, height = 55.dp)
                .clip(
                    RoundedCornerShape(
                        10.dp
                    )
                )
                .background(Color(0xFFFFA500))
                .border(
                    2.dp,
                    Color.Black,
                    RoundedCornerShape(
                        10.dp
                    )
                )
        ) {
            TextField(
                value = applicantPhoneNumber,
                onValueChange = {
                    applicantPhoneNumber = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                //.background(Color(0xFFFFA500))
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Alternate Number",
            fontSize = 13.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .size(width = 350.dp, height = 55.dp)
                .clip(
                    RoundedCornerShape(
                        10.dp
                    )
                )
                .background(Color(0xFFFFA500))
                .border(
                    2.dp,
                    Color.Black,
                    RoundedCornerShape(
                        10.dp
                    )
                )
        ) {
            TextField(
                value = alternateNumber,
                onValueChange = {
                    alternateNumber = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                //.background(Color(0xFFFFA500))
            )
        }
        Spacer(modifier = Modifier.height(90.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun ChildDetailsScreenPreview() {
    ChildDetailsScreen()
}
