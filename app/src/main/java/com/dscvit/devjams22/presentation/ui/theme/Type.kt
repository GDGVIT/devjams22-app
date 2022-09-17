package com.dscvit.devjams22.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.dscvit.devjams22.R

private val productSans = FontFamily(
    Font(R.font.productsansregular),
    Font(R.font.productsansbold, weight = FontWeight.Bold)
)

private val passionOne = FontFamily(
    Font(R.font.passionone)
)
val Typography = Typography(
    defaultFontFamily = productSans,


)