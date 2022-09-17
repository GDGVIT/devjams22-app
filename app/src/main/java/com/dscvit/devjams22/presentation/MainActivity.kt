package com.dscvit.devjams22.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.dscvit.devjams22.presentation.navigation.SetupNavGraph
import com.dscvit.devjams22.presentation.ui.theme.DevJams22Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevJams22Theme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)

            }
        }
    }
}

