package com.example.spaceece

import PilotLandingScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spaceece.feature_parent_auth.presentation.components.SplashScreen
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
                        SignupScreen(
                            onSignupButtonClicked = {
                                navController.navigate(Screens.PilotDetailScreen.name)
                            }
                        )
                    }

                    composable(route = Screens.ChampionScreen.name){
                        AppointmentListScreen()

                    }

                    composable(route = Screens.PilotDetailScreen.name) {
                        PilotLandingScreen()
                    }

                }


            }
        }
    }
}

enum class Screens{
    SplashScreen,
    SignupScreen,
    ChampionScreen,
    PilotDetailScreen
}
