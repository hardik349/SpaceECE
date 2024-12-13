package com.example.spaceece.feature_parent_details.presentation.components

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.FirebaseAuth

object FirestoreService {

//    private val db = FirebaseFirestore.getInstance()
//    private val auth = FirebaseAuth.getInstance()
//
//    // Function to upload child and parent details to Firestore in the "appointments" collection
//    fun uploadDetailsToFirestore(
//        context: Context, // Added context to show Toast messages
//        childName: String,
//        birthDate: String,
//        parentName: String,
//        spouseName: String?,
//        emailId: String,
//        phoneNumber: String,
//        alternateNumber: String?
//    ) {
//        val appointmentDetails = hashMapOf(
//            "parentDetails" to mapOf(
//                "applicantName" to parentName,
//                "spouseName" to spouseName,
//                "emailId" to emailId,
//                "phoneNumber" to phoneNumber,
//                "alternateNumber" to alternateNumber
//            ),
//            "childDetails" to mapOf(
//                "childName" to childName,
//                "birthDate" to birthDate
//            )
//        )
//
//        // Get current user ID to associate the data with the authenticated user
//        val currentUserId = auth.currentUser?.uid ?: return
//
//        // Reference to the "appointments" collection
//        val appointmentRef = db.collection("Appointments").document(currentUserId)
//
//        Log.d("FirestoreService", "Uploading appointment details to Firestore...")
//
//        // Add the combined details to Firestore
//        appointmentRef.collection("Appointments").add(appointmentDetails)
//            .addOnSuccessListener {
//                Log.d("FirestoreService", "Appointment details uploaded successfully.")
//                Toast.makeText(context, "Appointment details uploaded successfully!", Toast.LENGTH_SHORT).show()
//            }
//            .addOnFailureListener { e ->
//                Log.e("FirestoreService", "Failed to upload appointment details: ${e.message}")
//                Toast.makeText(context, "Failed to upload appointment details. Please try again.", Toast.LENGTH_SHORT).show()
//            }
//    }
//}
private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    // Function to upload child and parent details to Firestore in the "Appointments" collection
    fun uploadDetailsToFirestore(
        context: Context, // Added context to show Toast messages
        childName: String,
        birthDate: String,
        parentName: String,
        spouseName: String?,
        emailId: String,
        phoneNumber: String,
        alternateNumber: String?
    ) {
        val appointmentDetails = hashMapOf(
            "parentDetails" to mapOf(
                "applicantName" to parentName,
                "spouseName" to spouseName,
                "emailId" to emailId,
                "phoneNumber" to phoneNumber,
                "alternateNumber" to alternateNumber
            ),
            "childDetails" to mapOf(
                "childName" to childName,
                "birthDate" to birthDate
            )
        )

        // Reference to the "Appointments" collection
        val appointmentRef = db.collection("Appointments")

        Log.d("FirestoreService", "Uploading appointment details to Firestore...")

        // Add the combined details as a new document
        appointmentRef.add(appointmentDetails)
            .addOnSuccessListener { documentReference ->
                Log.d("FirestoreService", "Appointment details uploaded successfully with ID: ${documentReference.id}")
                Toast.makeText(context, "Appointment details uploaded successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Log.e("FirestoreService", "Failed to upload appointment details: ${e.message}")
                Toast.makeText(context, "Failed to upload appointment details. Please try again.", Toast.LENGTH_SHORT).show()
            }
    }
}