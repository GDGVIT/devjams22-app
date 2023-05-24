package com.dscvit.devjams22.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dscvit.devjams22.R

private val productSans = FontFamily(
    Font(R.font.productsansregular),
    Font(R.font.productsansbold, weight = FontWeight.Bold)
)

private val passionOne = FontFamily(
    Font(R.font.passionone)
)

private val redHat = FontFamily(
    Font(R.font.redhattextmedium, weight = FontWeight.Medium),
    Font(R.font.redhattextbold, weight = FontWeight.Bold),
    Font(R.font.redhattextsemibold, weight = FontWeight.SemiBold),
    Font(R.font.redhattextlight, weight = FontWeight.Light),
)
val Typography = Typography(
    defaultFontFamily = productSans,

    body1 = TextStyle(
        fontFamily = redHat,
        fontSize = 33.sp,
        fontWeight = FontWeight.SemiBold
    ),


    h1 = TextStyle(
        fontFamily = redHat,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),

    h2 = TextStyle(
        fontFamily = passionOne,
        fontSize = 45.sp
    ),
    h3 = TextStyle(
        fontFamily = redHat,
        fontWeight = FontWeight.Light
    )




)