package com.example.spaceece

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spaceece.pilot_screen.SignupScreen
import com.example.spaceece.ui.theme.SpaceECETheme
import com.example.spaceecepackage.AppointmentListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            SpaceECETheme {
                NavHost(
                    navController = navController ,
                    startDestination = Screens.SplashScreen.name
                ) {

                    composable(route = Screens.SplashScreen.name){
                        SplashScreen(
                            onChampionClicked = {
                                navController.navigate(Screens.ChampionScreen.name)
                            },
                            onPilotClicked = {
                                navController.navigate(Screens.SignupScreen.name)
                            }
                        )

                    }

                    composable(route = Screens.SignupScreen.name) {
                        SignupScreen()
                    }

                    composable(route = Screens.ChampionScreen.name){
                        AppointmentListScreen()

                    }

                }


            }
        }
    }
}

enum class Screens{
    SplashScreen,
    SignupScreen,
    ChampionScreen
}
