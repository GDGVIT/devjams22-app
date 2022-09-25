package com.dscvit.devjams22.presentation.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home")
    object Info : Screen("info")
    object Timeline : Screen("timeline")
}

