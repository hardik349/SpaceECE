package com.example.spaceece.champian_screen.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceece.R
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ChampionDashboard() {
    val appointments = remember { mutableStateListOf<Map<String, Any>>() }
    var errorMessage by remember { mutableStateOf("") }

    // Fetch data from Firestore
    LaunchedEffect(Unit) {
        fetchChampionAppointments(
            onSuccess = { fetchedAppointments ->
                appointments.clear()
                appointments.addAll(fetchedAppointments)
            },
            onError = { error ->
                errorMessage = error
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top App Bar
        CustomTopBar()

        Spacer(modifier = Modifier.height(24.dp))

        // Section for appointments
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Appointments",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Show error message if any
        if (errorMessage.isNotEmpty()) {
            Text(
                text = "Error: $errorMessage",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        } else {
            // Display appointments in LazyColumn
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                items(appointments.size) { index ->
                    val appointment = appointments[index]
                    val parentDetails = appointment["parentDetails"] as? Map<*, *>
                    val childDetails = appointment["childDetails"] as? Map<*, *>

                    AppointmentCard(
                        name = parentDetails?.get("applicantName") as? String ?: "Unknown",
                        spouseName = parentDetails?.get("spouseName") as? String ?: "N/A",
                        childName = childDetails?.get("childName") as? String ?: "Unknown",
                        date = childDetails?.get("birthDate") as? String ?: "Unknown"
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun AppointmentCard(name: String, spouseName: String, childName: String, date: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFF9800))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Parent: $name",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White
            )
            Text(
                text = "Spouse: $spouseName",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp
                ),
                color = Color.White
            )
            Text(
                text = "Child: $childName",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp
                ),
                color = Color.White
            )
            Text(
                text = "Date of Birth: $date",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp
                ),
                color = Color.White
            )
        }
    }
}

fun fetchChampionAppointments(
    onSuccess: (List<Map<String, Any>>) -> Unit,
    onError: (String) -> Unit
) {
    val db = FirebaseFirestore.getInstance()
    db.collection("Appointments")
        .get()
        .addOnSuccessListener { documents ->
            val appointments = mutableListOf<Map<String, Any>>()
            for (document in documents) {
                appointments.add(document.data)
            }
            onSuccess(appointments)
        }
        .addOnFailureListener { e ->
            Log.e("FirebaseError", "Error fetching appointments: ${e.message}", e)
            onError(e.message ?: "Unknown error occurred")
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
        title = {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.Black
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewChampionDashboard() {
    ChampionDashboard()
}