package com.example.spaceece.feature_parent_auth.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceece.R

@Composable
fun SplashScreen(
    modifier : Modifier = Modifier,
    onChampionClicked : () -> Unit,
    onPilotClicked : () -> Unit
){

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
               // .padding(30.dp)
                //.size(200.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Home Learning Made Easy",
            fontSize = 25.sp,
            style = MaterialTheme.typography.displayLarge

        )
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(R.drawable.splash_image),
            contentDescription = null,
            modifier = modifier.scale(1.25f)
            // .padding(30.dp)
            //.size(300.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Select Preferred Language",
            fontSize = 15.sp,
            style = MaterialTheme.typography.displayLarge

        )
        Box(
            modifier = Modifier
                .size(width = 300.dp, height = 45.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xFFFF9800))
                .clickable { onChampionClicked() }
        ){
            Text(
                text = "CHAMPIONS",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = modifier
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .size(width = 300.dp, height = 45.dp)
                .border(2.dp, Color(0xFFFF9800), RoundedCornerShape(100.dp))

                .background(Color.White)

                .clickable { onPilotClicked() }
        ){
            Text(
                text = "PILOT",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                modifier = modifier
                    .align(Alignment.Center)
            )
        }



    }


}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(
        onChampionClicked = {},
        onPilotClicked = {}
    )
}