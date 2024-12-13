package com.example.spaceece

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spaceece.champian_screen.components.ChampionDashboard
import com.example.spaceece.feature_parent_auth.presentation.components.AuthScreen
import com.example.spaceece.feature_parent_auth.presentation.components.ConfirmOtpScreen
import com.example.spaceece.feature_parent_auth.presentation.components.SelectRoleScreen
import com.example.spaceece.feature_parent_auth.presentation.components.SplashScreen
import com.example.spaceece.feature_parent_details.presentation.components.ChildDetailsScreen
import com.example.spaceece.pilot_screen.ChampionLoginScreen
import com.example.spaceece.ui.theme.SpaceECETheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this)
        setContent {
            //routes
            val navController = rememberNavController()
            SpaceECETheme {
                NavHost(
                    navController = navController,
                    startDestination = Screens.SplashScreen.name
                ) {
                    composable(route = Screens.SplashScreen.name) {
                        SplashScreen(
                            onLanguageButtonClicked = {},
                            onDefaultLanguageClicked = {},
                            onNextButtonClicked = {
                                navController.navigate(Screens.SelectRoleScreen.name)
                            }
                        )
                    }
                    composable(route = Screens.SelectRoleScreen.name) {
                        SelectRoleScreen(
                            onBackLanguageClicked = {
                                navController.popBackStack()
                            },
                            onBeginButtonClicked = { selectedRole ->
                                when (selectedRole) {
                                    "Parent" -> navController.navigate(Screens.AuthScreen.name)
                                    "Champion" -> navController.navigate(Screens.ChampionLoginScreen.name)
                                }
                            },
                        )
                    }
                    composable(route = Screens.AuthScreen.name) {
                        AuthScreen(
                            onLoginSuccessful = {
                                navController.navigate(Screens.ChildDetailsScreen.name)
                            },
                            onLoginUnSuccessful = {
                                navController.navigate(Screens.ConfirmOtpScreen.name)
                            }
                        )
                    }
                    composable(route = Screens.ConfirmOtpScreen.name) {
                        ConfirmOtpScreen(
                            onRegistrationSuccessful = {
                                navController.navigate(Screens.ChildDetailsScreen.name)
                            },
                            onBackToLogin = {
                                navController.navigate(Screens.AuthScreen.name)
                            }
                        )
                    }
                    composable(route = Screens.ChildDetailsScreen.name) {
                        ChildDetailsScreen()
                    }
                    composable(route = Screens.ChampionLoginScreen.name) {
                        ChampionLoginScreen(
                            onLoginButtonClicked = {
                                navController.navigate(Screens.ChampionDashboardScreen.name)
                            },
                            onForgotPasswordClicked = {}
                        )
                    }
                    composable(route = Screens.ChampionDashboardScreen.name) {
                        ChampionDashboard()
                    }
                }
            }
        }
    }
}

enum class Screens {
    SplashScreen,
    SelectRoleScreen,
    AuthScreen,
    ConfirmOtpScreen,
    ChildDetailsScreen,
    ChampionLoginScreen,
    ChampionDashboardScreen
}
