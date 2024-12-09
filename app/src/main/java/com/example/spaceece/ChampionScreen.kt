package com.example.spaceecepackage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppointmentListScreen() {
    val appointments = listOf(
        mapOf("name" to "John Doe", "age" to "30", "gender" to "Male", "date" to "2024-12-10"),
        mapOf("name" to "Jane Smith", "age" to "28", "gender" to "Female", "date" to "2024-12-12"),
        mapOf("name" to "Michael Brown", "age" to "35", "gender" to "Male", "date" to "2024-12-15"),
        mapOf("name" to "John Doe", "age" to "30", "gender" to "Male", "date" to "2024-12-10"),
        mapOf("name" to "Jane Smith", "age" to "28", "gender" to "Female", "date" to "2024-12-12"),
        mapOf("name" to "Michael Brown", "age" to "35", "gender" to "Male", "date" to "2024-12-15"),
        mapOf("name" to "John Doe", "age" to "30", "gender" to "Male", "date" to "2024-12-10"),
        mapOf("name" to "Jane Smith", "age" to "28", "gender" to "Female", "date" to "2024-12-12"),
        mapOf("name" to "Michael Brown", "age" to "35", "gender" to "Male", "date" to "2024-12-15")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Champion",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 55.sp,
                fontWeight = FontWeight.Bold),
            color = Color.Black.copy(alpha = 0.7f),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(appointments.size) { index ->
                val appointment = appointments[index]
                AppointmentCard(
                    name = appointment["name"] ?: "",
                    age = appointment["age"] ?: "",
                    gender = appointment["gender"] ?: "",
                    date = appointment["date"] ?: ""
                )
            }
        }
    }
}

@Composable
fun AppointmentCard(name: String, age: String, gender: String, date: String) {
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
                text = "Name: $name",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White
            )
            Text(
                text = "Age: $age",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp
                ),
                color = Color.White
            )
            Text(
                text = "Gender: $gender",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp
                ),
                color = Color.White
            )
            Text(
                text = "Date: $date",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp
                ),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppointmentListScreen() {
    AppointmentListScreen()
}
