package com.dscvit.devjams22.presentation


import android.content.pm.ActivityInfo
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dscvit.devjams22.R
import com.dscvit.devjams22.presentation.navigation.Screen
import com.dscvit.devjams22.presentation.ui.theme.*
import kotlinx.coroutines.delay


@Composable
fun SplashAnimation(navController: NavHostController) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    SplashScreen(alphaAnim.value)
}

@Composable
fun SplashScreen(alpha: Float) {

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .alpha(alpha),


        ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = GoogleRed,
                        fontSize = 45.sp
                    )
                ) {
                    append("D")
                }
                withStyle(
                    style = SpanStyle(
                        color = GoogleBlue,
                        fontSize = 45.sp
                    )
                ) {
                    append("e")
                }
                withStyle(
                    style = SpanStyle(
                        color = GoogleYellow,
                        fontSize = 45.sp
                    )
                ) {
                    append("v")
                }
                withStyle(
                    style = SpanStyle(
                        color = GoogleGreen,
                        fontSize = 45.sp,
                        letterSpacing = (-15).sp
                    )
                ) {
                    append("J")
                }
                withStyle(
                    style = SpanStyle(
                        color = GoogleBlue,
                        fontSize = 45.sp
                    )
                ) {
                    append("a")
                }
                withStyle(
                    style = SpanStyle(
                        color = GoogleRed,
                        fontSize = 45.sp
                    )
                ) {
                    append("m")
                }
                withStyle(
                    style = SpanStyle(
                        color = GoogleYellow,
                        fontSize = 45.sp
                    )
                ) {
                    append("s")
                }
                withStyle(
                    style = SpanStyle(
                        color = GoogleGreen,
                        fontSize = 45.sp,
                        letterSpacing = 3.sp

                    )
                ) {
                    append("'")
                }
                withStyle(
                    style = SpanStyle(
                        color = GoogleBlue,
                        fontSize = 45.sp

                    )
                ) {
                    append("2")
                }
                withStyle(
                    style = SpanStyle(
                        color = GoogleBlue,
                        fontSize = 45.sp,
                        letterSpacing = (0).sp

                    )
                ) {
                    append("2")
                }
            },
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 20.dp),
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = (-6).sp
        )


        Box(
            modifier = Modifier
                .background(color = Color.White),

            contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.blue_splash), contentDescription = null,
                modifier = Modifier
            )


            Image(
                painter = painterResource(id = R.drawable.dj_blimp),
                contentDescription = "blimp",
                modifier = Modifier.width(350.dp)
            )

        }


    }


}




