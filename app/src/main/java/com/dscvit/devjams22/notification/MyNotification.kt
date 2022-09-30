package com.dscvit.devjams22.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dscvit.devjams22.R

@Preview(showSystemUi = true)
@Composable
fun MyNotification() {
    Row(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.devjams),
            contentDescription = "logo",
            modifier = Modifier.padding(top = 20.dp, start = 10.dp)
        )

        Column(modifier = Modifier) {
            Text(
                text = "Title", modifier = Modifier.padding(start = 8.dp, top = 10.dp),
                fontWeight = FontWeight.Bold, fontSize = 20.sp
            )

            Text(
                text = "This is the description",
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )

        }

    }

}