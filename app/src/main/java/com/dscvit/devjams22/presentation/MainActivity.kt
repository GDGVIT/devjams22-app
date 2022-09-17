package com.dscvit.devjams22.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    DevJams22Theme {
//        Greeting("DevJams'22")
//    }
//}

// A surface container using the 'background' color from the theme
//Surface(
//modifier = Modifier.fillMaxSize(),
//color = MaterialTheme.colors.background
//) {
//    Greeting("DevJams'22")
//}