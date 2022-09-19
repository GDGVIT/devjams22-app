package com.dscvit.devjams22.presentation.navbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dscvit.devjams22.presentation.home.components.Home
import com.dscvit.devjams22.presentation.info.components.Info
import com.dscvit.devjams22.presentation.navigation.Screen
import com.dscvit.devjams22.presentation.profile.components.Profile

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            Home()
        }

        composable(route = Screen.Info.route) {
            Info()
        }

        composable(route = Screen.Profile.route) {
            Profile()
        }

    }

}