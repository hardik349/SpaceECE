package com.example.spaceece.feature_parent_auth.presentation.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceece.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    onLoginSuccessful: () -> Unit,
    onLoginUnSuccessful: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val auth: FirebaseAuth = Firebase.auth

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = modifier.padding(top = 30.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Home Learning Made Easy",
            fontSize = 23.sp,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Email Input
        Text(
            text = "Enter Email",
            fontSize = 13.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFA500))
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
        ) {
            TextField(
                value = email,
                onValueChange = { email = it },
                colors = TextFieldDefaults.textFieldColors(
                    focusedTextColor = Color.Black,
                    containerColor = Color(0xFFFFA500)
                ),
                placeholder = { Text(text = "example@email.com") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                modifier = modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Password Input
        Text(
            text = "Enter Password",
            fontSize = 13.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFA500))
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
        ) {
            TextField(
                value = password,
                onValueChange = { password = it },
                colors = TextFieldDefaults.textFieldColors(
                    focusedTextColor = Color.Black,
                    containerColor = Color(0xFFFFA500)
                ),
                placeholder = { Text(text = "Password") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                },
                modifier = modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        // Login Button
        Box(
            modifier = Modifier
                .size(width = 280.dp, height = 50.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFFFFA500))
                .border(3.dp, Color.Black, RoundedCornerShape(30.dp))
                .clickable {
                    // Validate email and password
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        scope.launch {
                            try {
                                auth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                                            onLoginSuccessful()
                                        } else {
                                            Toast.makeText(context, "Authentication Failed", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                            } catch (e: Exception) {
                                Toast.makeText(context, "Error: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show()
                    }
                }
        ) {
            Text(
                text = "Login",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                modifier = modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Register Button
        Text(
            text = "Don't have an account? Register",
            color = Color.Blue,
            modifier = Modifier.clickable {
                onLoginUnSuccessful()
            }
        )

        Spacer(modifier = modifier.height(100.dp))

        Image(
            painter = painterResource(R.drawable.splash_image),
            contentDescription = null,
            modifier = modifier.scale(1.25f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen(
        onLoginSuccessful = {},
        onLoginUnSuccessful = {}
    )
}
