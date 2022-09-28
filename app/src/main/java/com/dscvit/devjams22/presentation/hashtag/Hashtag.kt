package com.dscvit.devjams22.presentation.hashtag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.dscvit.devjams22.presentation.ui.theme.GoogleBlue
import com.dscvit.devjams22.presentation.ui.theme.GreyBackground

@Composable
fun Hashtag() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Coming Soon!", fontWeight = FontWeight.SemiBold, color = GoogleBlue)

    }

}