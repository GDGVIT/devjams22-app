package com.dscvit.devjams22.presentation.navbar

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dscvit.devjams22.presentation.navigation.Screen
import com.dscvit.devjams22.presentation.navigation.SetupNavGraph

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        "splash_screen" -> false
        "timeline" -> false
        else -> true
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem(
                            name = "Info",
                            route = Screen.Info.route,
                            icon = Icons.Default.Info
                        ),
                        BottomNavItem(
                            name = "Home",
                            route = Screen.Home.route,
                            icon = Icons.Default.Home
                        ),
                        BottomNavItem(
                            name = "Profile",
                            route = Screen.Profile.route,
                            icon = Icons.Default.Person
                        )
                    ),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    }
                )
            }


        }
    ) {
        SetupNavGraph(navController = navController)

    }

}