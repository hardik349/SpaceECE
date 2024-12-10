package com.example.spaceece.feature_parent_auth.presentation.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceece.R
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    onSendButtonClicked : () -> Unit,
    modifier : Modifier = Modifier
){

    var phoneNumber by remember { mutableStateOf("") }
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
            text = "Enter Phone Number",
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
        ){
            TextField(
                value = phoneNumber,
                onValueChange = {
                    phoneNumber = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedTextColor = Color.Black,
                    containerColor = Color(0xFFFFA500)
                ),
                placeholder = { Text(text = "123456789")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFA500))
            )

        }
        Spacer(modifier = Modifier.height(35.dp))
        Box(
            modifier = Modifier
                .size(width = 280.dp, height = 50.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFFFFA500))
                .border(
                    3.dp, Color.Black, RoundedCornerShape(30.dp)
                )
                .clickable { onSendButtonClicked() }
        ){
            Text(
                text = "Send OTP",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                modifier = modifier
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = modifier.height(180.dp))
        Image(
            painter = painterResource(R.drawable.splash_image),
            contentDescription = null,
            modifier = modifier.scale(1.25f)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview(){
    AuthScreen(
        onSendButtonClicked = {}
    )
}