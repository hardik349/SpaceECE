package com.example.spaceece.pilot_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceece.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen(
    onResendOtpClicked: () -> Unit,
    onConfirmOtpClicked: () -> Unit
) {
    var otpInputs = remember { mutableStateListOf("", "", "", "", "", "") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Home Learning Made Easy",
            fontSize = 20.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        // OTP input boxes
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            otpInputs.forEachIndexed { index, otpValue ->
                OutlinedTextField(
                    value = otpValue,
                    onValueChange = { newValue ->
                        if (newValue.length <= 1) {
                            otpInputs[index] = newValue
                        }
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = if (index == otpInputs.lastIndex) ImeAction.Done else ImeAction.Next
                    ),
                    modifier = Modifier
                        .width(48.dp)
                        .height(56.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(36.dp))

        // Buttons in a row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { onResendOtpClicked() },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF03A9F4),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Resend OTP",
                    fontSize = 16.sp
                )
            }

            Button(
                onClick = { onConfirmOtpClicked() },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .padding(start = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF9800),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Confirm",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(230.dp))

        Image(
            painter = painterResource(id = R.drawable.splash_image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .aspectRatio(1f)
                .padding(all = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOtpScreen() {
    OtpScreen(
        onResendOtpClicked = {},
        onConfirmOtpClicked = {}
    )
}
