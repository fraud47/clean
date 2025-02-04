package com.hamsoft.cleaning_services.ui

sealed class Screen(val route: String) {
    object AuthScreen: Screen("auth_screen")
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
}