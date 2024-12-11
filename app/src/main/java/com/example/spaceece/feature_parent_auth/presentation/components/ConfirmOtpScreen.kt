package com.example.spaceece.feature_parent_auth.presentation.components

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spaceece.R
import com.example.spaceece.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmOtpScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var phoneNumber by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = modifier
                .padding(top = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Home Learning Made Easy",
            fontSize = 23.sp,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Edit Phone Number",
            fontSize = 13.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .size(width = 350.dp, height = 55.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFA500))
                .border(
                    2.dp,
                    Color.Black,
                    RoundedCornerShape(10.dp)
                )
        ) {
            TextField(
                value = phoneNumber,
                onValueChange = {
                    phoneNumber = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedTextColor = Color.Black,
                ),
                placeholder = { Text(text = "123456789") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = modifier
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 160.dp, height = 50.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFCBF5F1))
                    .border(
                        2.dp,
                        Color.Black,
                        RoundedCornerShape(30.dp)
                    )
                    .clickable { }
            ) {
                Text(
                    text = "Resend OTP",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    modifier = modifier
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(width = 160.dp, height = 50.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFFFA500))
                    .border(
                        2.dp,
                        Color.Black,
                        RoundedCornerShape(30.dp)
                    )
                    .clickable {
                        println(otp)
                        if (otp == "123456") {
                            showError = false
                            // Navigate to next screen
                            navController.navigate(Screens.ChildDetailsScreen.name)
                        } else {
                            showError = true
                        }
                    }
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
                        modifier = modifier.padding(start = 20.dp, top = 4.dp)
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

        // Error message display
        if (showError) {
            Text(
                text = "Incorrect OTP. Please try again.",
                color = Color.Red,
                modifier = Modifier.padding(top = 10.dp)
            )
        }

        Spacer(modifier = modifier.height(40.dp))
        Text(
            text = "Enter OTP",
            fontSize = 13.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 30.dp)
        )
        Spacer(modifier = modifier.height(10.dp))

        // var otp by remember { mutableStateOf("") }

        fun updateOTP(newInput: String) {
            if (newInput.length <= 6) {
                otp = newInput
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            for (i in 0 until 6) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .border(2.dp, Color(0xFFFFA500), RoundedCornerShape(8.dp))
                        .background(Color(0xFFFFA500), RoundedCornerShape(8.dp))
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val char = if (i < otp.length) otp[i].toString() else ""
                    BasicTextField(
                        value = char,
                        onValueChange = { newInput ->
                            val updated = otp.toMutableList()
                            if (newInput.isNotEmpty() && i < updated.size) {
                                updated[i] = newInput.first()
                            } else if (newInput.isNotEmpty()) {
                                updated.add(newInput.first())
                            }
                            updateOTP(updated.joinToString(""))
                        },
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 24.sp,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        ),
                        singleLine = true,
                        maxLines = 1,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }


        Spacer(modifier = modifier.height(70.dp))
        Image(
            painter = painterResource(R.drawable.splash_image),
            contentDescription = null,
            modifier = modifier.scale(1.25f)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpBox(
    text: String,
    onTextChanged: (String) -> Unit,
) {
    TextField(

        value = text,
        onValueChange = { newValue ->
            // Only update if the new value is a single digit
            if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                onTextChanged(newValue)
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent
        ),
        placeholder = { Text(text = "0") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFFFA500))
            .border(
                2.dp,
                Color.Black,
                RoundedCornerShape(10.dp)
            )
            .padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ConfirmOtpScreenPreview() {
    val navController = rememberNavController()
    ConfirmOtpScreen(navController = navController)
}
