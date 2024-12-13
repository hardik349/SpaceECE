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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceece.R

@Composable
fun SelectRoleScreen(
    modifier : Modifier = Modifier,
    onBackLanguageClicked : () -> Unit,
    onBeginButtonClicked : (String) -> Unit
){
    var selectedRole by remember { mutableStateOf("") }

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
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(R.drawable.splash_image),
            contentDescription = null,
            modifier = modifier.scale(1.25f)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Select Role",
            fontSize = 13.sp,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        RoleDropDown(
            selectedRole = selectedRole,
            onRoleSelected = {selectedRole = it}
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Welcome!",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 150.dp, height = 60.dp)
                    .clip(
                        RoundedCornerShape(30.dp)
                    )
                    .background(Color(0xFFCBF5F1))
                    .border(
                        2.dp,
                        Color.Black,
                        RoundedCornerShape(30.dp)
                    )
                    .clickable { onBackLanguageClicked() }
            ){
                Text(
                    text = "Back",
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
                    .size(width = 150.dp, height = 60.dp)
                    .clip(
                        RoundedCornerShape(30.dp)
                    )
                    .background(Color(0xFFFFA500))
                    .border(
                        2.dp,
                        Color.Black,
                        RoundedCornerShape(30.dp)
                    )
                    .clickable { onBeginButtonClicked(selectedRole) }
            ){
                Row(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Begin",
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        modifier = modifier.padding(start = 10.dp, top = 4.dp)
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
    }
}

@Composable
fun RoleDropDown(
    selectedRole : String,
    onRoleSelected : (String) -> Unit

){
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .size(width = 350.dp, height = 48.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 25.dp,
                    bottomEnd = 25.dp
                )
            )
            .background(Color(0xFFFFA500))
            .border(
                2.dp,
                Color.Black,
                RoundedCornerShape(
                    topStart = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 25.dp,
                    bottomEnd = 25.dp
                )
            )
            .clickable { expanded = !expanded }
    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 10.dp, end = 5.dp)
        ) {

            Text(
                text = selectedRole.ifEmpty { "Select Role" },
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 5.dp)
                //.align(Alignment.Center)
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(37.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(30.dp)
                )

            }

        }

    }
    Box(
        modifier = Modifier
            .padding(start = 1.dp,end = 1.dp)
    ) {

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x= 100.dp, y= 3.dp),
            modifier = Modifier

                .width(250.dp)
                .background(Color(0xFFFFA500).copy(alpha = 0.9f))
                .clip(RoundedCornerShape(25.dp)),
            //offset = DpOffset(x = 4.dp, y = 10.dp)
        ) {
            DropdownMenuItem(
                text = { Text(text = "Parent")},
                onClick = {
                    onRoleSelected("Parent")
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(text = "Champion")},
                onClick = {
                    onRoleSelected("Champion")
                    expanded = false
                }
            )

        }
    }


}

@Preview(showBackground = true)
@Composable
fun SelectRoleScreenPreview(){
    SelectRoleScreen(
        onBackLanguageClicked = {},
        onBeginButtonClicked = {}
    )
}