package com.dscvit.devjams22.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dscvit.devjams22.R
import com.dscvit.devjams22.presentation.navigation.Screen
import com.dscvit.devjams22.presentation.ui.theme.GoogleBlue
import com.dscvit.devjams22.presentation.ui.theme.GoogleGreen
import com.dscvit.devjams22.presentation.ui.theme.GoogleRed
import com.dscvit.devjams22.presentation.ui.theme.GoogleYellow


@Composable
fun SplashScreen(navController: NavController) {

    Column(
        modifier = Modifier.background(color = Color.White)
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
                .background(color = Color.White)
                .fillMaxSize(),
            contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.blue_splash), contentDescription = null,
                modifier = Modifier

                    .width(800.dp)

            )
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.dj_blimp),
                    contentDescription = "blimp",
                    modifier = Modifier.width(350.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = colorResource(id = R.color.blue_button))
                        .fillMaxWidth(.80f)
                        .height(60.dp)
                        .align(CenterHorizontally)
                        .clickable {
                            navController.navigate(route = Screen.Home.route)
                        }

                ) {
                    Spacer(modifier = Modifier.width(60.dp))
                    Text(
                        text = "G",
                        color = Color.White,
                        modifier = Modifier.align(CenterVertically),
                        style = MaterialTheme.typography.body1

                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Continue with Google",
                        color = Color.White,
                        modifier = Modifier.align(CenterVertically),
                        style = MaterialTheme.typography.h1

                    )
                }

            }

        }


    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewSplash() {
    SplashScreen(navController = rememberNavController())
}



