package com.example.spaceece.champian_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceece.R

@Preview(showBackground = true)
@Composable
fun ChampionDashboardPreview() {
    ChampionDashboard()
}

@Composable
fun ChampionDashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { },
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF5E1)),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomTopBar()
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { },
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF5E1)),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Add another child\nAges allowed : 0 - 8 years",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { },
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA)),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Samira\nAge - 6 years",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFA500))
        ) {
            Text(
                text = "Child's Profile",
                fontSize = 35.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.noto_sans)),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .border(3.dp, Color.Black, CircleShape)
                        .clip(CircleShape)
                        .background(Color(0xFFCBF5F1))
                ) {
                    Image(
                        painter = painterResource(R.drawable.child),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center),
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(start = 30.dp)
                ) {
                    Text(
                        text = "Child's Name",
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Box(
                        modifier = Modifier
                            .size(width = 250.dp, height = 50.dp)
                            .clip(
                                RoundedCornerShape(10.dp)
                            )
                            .background(Color(0xFFFFA500))
                            .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                    ) {
                        TextField(
                            value = "Chandu",
                            onValueChange = {},
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFFFA500))
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Child's Curriculum",
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Box(
                        modifier = Modifier
                            .size(width = 250.dp, height = 50.dp)
                            .clip(
                                RoundedCornerShape(10.dp)
                            )
                            .background(Color(0xFFFFA500))
                            .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                    ) {
                        TextField(
                            value = "Level 3",
                            onValueChange = {},
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFFFA500))
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 400.dp, height = 60.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFFFA500))
                    .border(2.dp, Color.Black, RoundedCornerShape(30.dp))
                    .align(Alignment.Center)
                    .clickable { }
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Let's Get Started",
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 10.dp, top = 4.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
        title = {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.Black
                )
            }
        }
    )
}



