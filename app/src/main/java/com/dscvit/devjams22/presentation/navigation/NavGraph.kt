package com.dscvit.devjams22.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dscvit.devjams22.presentation.SplashAnimation
import com.dscvit.devjams22.presentation.announcements.Announcement
import com.dscvit.devjams22.presentation.hashtag.Hashtag
import com.dscvit.devjams22.presentation.hashtag.HashtagViewModel
import com.dscvit.devjams22.presentation.home.components.Home
import com.dscvit.devjams22.presentation.info.components.Info
import com.dscvit.devjams22.presentation.timeline.Timeline


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {


        composable(route = Screen.Splash.route) {
            SplashAnimation(navController = navController)
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

        composable(route = Screen.Announcement.route) {
            Announcement()
        }

        composable(route = Screen.Hashtag.route) {
            val viewModel = hiltViewModel<HashtagViewModel>()
            Hashtag(viewModel)
        }

    }
}