package com.dscvit.devjams22.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.rememberNavController
import com.dscvit.devjams22.presentation.navbar.MainScreen
import com.dscvit.devjams22.presentation.navigation.SetupNavGraph
import com.dscvit.devjams22.presentation.ui.theme.DevJams22Theme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevJams22Theme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
                MainScreen()

            }
        }
    }
}

