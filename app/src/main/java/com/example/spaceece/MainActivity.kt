package com.example.spaceece

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spaceece.feature_parent_auth.presentation.components.AuthScreen
import com.example.spaceece.feature_parent_auth.presentation.components.ConfirmOtpScreen
import com.example.spaceece.feature_parent_auth.presentation.components.SelectRoleScreen
import com.example.spaceece.feature_parent_auth.presentation.components.SplashScreen
import com.example.spaceece.ui.theme.SpaceECETheme

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
                            onLanguageButtonClicked = {},
                            onDefaultLanguageClicked = {},
                            onNextButtonClicked = {
                                navController.navigate(Screens.SelectRoleScreen.name)

                            }
                        )
                    }

                    composable(route = Screens.SelectRoleScreen.name){
                        SelectRoleScreen(
                            onBackLanguageClicked = {
                                navController.popBackStack()
                            },
                            onBeginButtonClicked = {
                                navController.navigate(Screens.AuthScreen.name)
                            },
                            onRoleButtonClicked = {}
                        )
                    }

                    composable(route = Screens.AuthScreen.name){
                        AuthScreen(
                            onSendButtonClicked = {
                                navController.navigate(Screens.ConfirmOtpScreen.name)
                            }
                        )
                    }

                    composable(route = Screens.ConfirmOtpScreen.name){
                        ConfirmOtpScreen()
                    }

                }


            }
        }
    }
}

enum class Screens{
    SplashScreen,
    SelectRoleScreen,
    AuthScreen,
    ConfirmOtpScreen,
}
