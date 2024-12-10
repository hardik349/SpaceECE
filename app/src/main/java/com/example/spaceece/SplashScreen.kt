package com.example.spaceece

import android.window.SplashScreen
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SplashScreen(
    modifier : Modifier = Modifier,
    onChampionClicked : () -> Unit,
    onPilotClicked : () -> Unit
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.background(Color.White)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.spaceece),
            contentDescription = null,
            modifier = modifier
                .padding(30.dp)
                .size(200.dp)
        )
        Spacer(modifier = Modifier.height(140.dp))
        Box(
            modifier = Modifier
                .size(width = 300.dp, height = 45.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xFFFF9800))
                .clickable { onChampionClicked()}
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
                .border(2.dp,Color(0xFFFF9800),RoundedCornerShape(100.dp))

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