package com.hamsoft.cleaning_services.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.hamsoft.cleaning_services.ui.auth.AuthenticationScreen
import com.hamsoft.cleaning_services.ui.auth.login_screen.LoginScreen


@Composable
fun NavigationScreen() {
    Scaffold { it ->
        Box(modifier = Modifier.padding(it)) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.AuthScreen.route
            ) {
                composable(
                    route = Screen.AuthScreen.route
                ) {
                    AuthenticationScreen(navController = navController)
                }
                composable(
                    route = Screen.LoginScreen.route,


                    ) {
                    LoginScreen( navController= navController)
                }
            }
        }
    }

    
}