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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.example.spaceece.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmOtpScreen(
    modifier : Modifier = Modifier
){
    var phoneNumber by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
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
                value = phoneNumber,
                onValueChange = {
                    phoneNumber = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedTextColor = Color.Black,
                   // containerColor = Color.Transparent
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
                    .clip(
                        RoundedCornerShape(30.dp)
                    )
                    .background(Color(0xFFCBF5F1))
                    .border(
                        2.dp,
                        Color.Black,
                        RoundedCornerShape(30.dp)
                    )
                    .clickable { }
            ){
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
                    .clip(
                        RoundedCornerShape(30.dp)
                    )
                    .background(Color(0xFFFFA500))
                    .border(
                        2.dp,
                        Color.Black,
                        RoundedCornerShape(30.dp)
                    )
                    .clickable { }
            ){
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

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            OtpBox(
                text = otp.getOrNull(0)?.toString() ?: "",
                onTextChanged = {
                    if (it.length <= 1) {
                        otp = otp.substring(0, 0) + it + otp.substring(1)
                    }
                }
            )
            OtpBox(
                text = otp.getOrNull(1)?.toString() ?: "",
                onTextChanged = {
                    if (it.length <= 1) {
                        otp = otp.substring(0, 1) + it + otp.substring(2)
                    }
                }
            )
            OtpBox(
                text = otp.getOrNull(2)?.toString() ?: "",
                onTextChanged = {
                    if (it.length <= 1) {
                        otp = otp.substring(0, 2) + it + otp.substring(3)
                    }
                }
            )
            OtpBox(
                text = otp.getOrNull(3)?.toString() ?: "",
                onTextChanged = {
                    if (it.length <= 1) {
                        otp = otp.substring(0, 3) + it + otp.substring(4)
                    }
                }
            )
            OtpBox(
                text = otp.getOrNull(4)?.toString() ?: "",
                onTextChanged = {
                    if (it.length <= 1) {
                        otp = otp.substring(0, 4) + it + otp.substring(5)
                    }
                }
            )
            OtpBox(
                text = otp.getOrNull(5)?.toString() ?: "",
                onTextChanged = {
                    if (it.length <= 1) {
                        otp = otp.substring(0, 5) + it
                    }
                }
            )
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
        onValueChange =onTextChanged,
        colors = TextFieldDefaults.textFieldColors(

            containerColor = Color.Transparent
        ),
        placeholder = { Text(text = "123456789") },
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
fun ConfirmOtpScreenPreview(){
    ConfirmOtpScreen()
}