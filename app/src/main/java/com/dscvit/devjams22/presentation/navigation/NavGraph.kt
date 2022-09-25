package com.dscvit.devjams22.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dscvit.devjams22.presentation.SplashScreen
import com.dscvit.devjams22.presentation.home.components.Home
import com.dscvit.devjams22.presentation.info.components.Info
import com.dscvit.devjams22.presentation.timeline.Timeline


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            Home(navController = navController)
        }

        composable(route = Screen.Info.route) {
            Info()
        }

        composable(route = Screen.Timeline.route) {
            Timeline()
        }

    }
}