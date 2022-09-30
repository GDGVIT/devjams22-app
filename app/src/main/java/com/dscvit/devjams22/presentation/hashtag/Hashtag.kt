package com.dscvit.devjams22.presentation.hashtag

import android.content.pm.ActivityInfo
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.dscvit.devjams22.R
import com.dscvit.devjams22.data.remote.dto.Data
import com.dscvit.devjams22.data.remote.dto.InstaFeed
import com.dscvit.devjams22.presentation.components.ProgressBar
import com.dscvit.devjams22.presentation.ui.theme.GreyBackground
import com.dscvit.devjams22.presentation.ui.theme.LockScreenOrientation

@Composable
fun Hashtag(
    hashtagViewModel: HashtagViewModel = viewModel()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val state: InstaFeed by hashtagViewModel.state.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground)
    ) {
        Text(
            text = "#PeanutButterandDevJams",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(GreyBackground),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            LazyColumn() {
                if (state.data.isEmpty()) {
                    item {
                        ProgressBar(isDisplayed = true)
                    }
                }
                var count = 0

                items(state.data) { hashtag: Data ->
                    if (hashtag.media_type == "IMAGE") {
                        Cards(hashtagDC = hashtag, pos = count++)
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                    Log.d("hashtag", hashtag.toString())


                }

            }

        }

    }


}


@Composable
fun Cards(hashtagDC: Data, pos: Int) {
    val imagePainter = rememberImagePainter(data = hashtagDC.media_url)

    Box(
        modifier = Modifier
            .height(420.dp)
            .width(380.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = getCardColor(pos))


    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "@gdscvitvellore",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 12.dp, top = 8.dp)
            )

            Text(
                text = "VIT VELLORE",
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .align(CenterHorizontally)
            ) {
                Image(
                    
                    painter = imagePainter,
                    contentDescription = null,
                    modifier = Modifier

                        .padding(bottom = 5.dp, start = 5.dp, end = 5.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.Crop
                )
            }


        }
    }

}

@Composable
fun getCardColor(pos: Int): Color {
    return if (pos % 4 == 0) {
        colorResource(id = R.color.GoogleRed_Light)
    } else if (pos % 4 == 1) {
        colorResource(id = R.color.GoogleYellow_Light)
    } else if (pos % 4 == 2) {
        colorResource(id = R.color.GoogleBlue_Light)
    } else {
        colorResource(id = R.color.GoogleGreen_Light)
    }
}

