package com.dscvit.devjams22.presentation.home.components

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dscvit.devjams22.R
import com.dscvit.devjams22.common.Constants
import com.dscvit.devjams22.common.State
import com.dscvit.devjams22.data.remote.dto.TimelineDC
import com.dscvit.devjams22.presentation.navigation.Screen
import com.dscvit.devjams22.presentation.timeline.EventsViewModel
import com.dscvit.devjams22.presentation.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
@Composable
fun Home(navController: NavController, viewModel: EventsViewModel = viewModel()) {
    val postsState: State<List<TimelineDC>> by viewModel.postState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 70.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 32.dp, start = 32.dp)
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
                modifier = Modifier,

                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-6).sp,

                )

            Spacer(modifier = Modifier.width(85.dp))

            Row(
                modifier = Modifier
                    .padding(top = 10.dp, end = 10.dp)
            ) {

                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(Color.White)


                ) {
                    Image(
                        painter = painterResource(id = R.drawable.notification),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(24.dp)
                    )

                }


            }

        }

        OpenDiscord()

        Card(
            backgroundColor = GreyBackground,
            elevation = 0.dp,

            ) {
            Image(
                painter = painterResource(id = R.drawable.hashtag), contentDescription = null,
                modifier = Modifier.padding(start = 12.dp)
            )

            Column(modifier = Modifier.padding(top = 40.dp, start = 45.dp)) {
                Text(
                    text = "Hashtag",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )

                Text(
                    text = "Trending Posts",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp
                )

            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Timeline",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 20.dp)
        )
        val timeNow = SimpleDateFormat("yyyy.MM.dd G HH:mm:ss z")
        val getCurrentTimeAndDate = timeNow.format(Date())


        when (postsState) {
            is State.Loading -> {
                Log.d("load", "loading")
            }

            is State.Success -> {

                for (event in (postsState as State.Success<List<TimelineDC>>).data) {
                    val eventSDF = SimpleDateFormat("yyyy.MM.dd G HH:mm:ss z")
                    val eventTimeAndDateStart =
                        event.startTime?.toDate()?.let { eventSDF.format(it) }

                    val startTimeSDF = SimpleDateFormat("ha")
                    val startTime = event.startTime?.toDate()?.let { startTimeSDF.format(it) }

                    val endTimeSDF = SimpleDateFormat("ha")
                    val endTime = event.endTime?.toDate()?.let { endTimeSDF.format(it) }

                    if (getCurrentTimeAndDate < eventTimeAndDateStart!!) {
                        TimelineCard(
                            navController,
                            event.eventName.toString(),
                            startTime.toString(),
                            endTime.toString()
                        )
                        break
                    }

                }

            }

            is State.Failed -> {
                Text(text = (postsState as State.Failed<List<TimelineDC>>).message)
                Log.d("Failed", (postsState as State.Failed<List<TimelineDC>>).message)
            }
        }


    }
}

@Composable
fun TimelineCard(navController: NavController, event: String, start: String, end: String) {
    Card(
        backgroundColor = GreyBackground,
        elevation = 0.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.timeline), contentDescription = null,
            modifier = Modifier.padding(start = 12.dp)
        )

        Column(modifier = Modifier.padding(top = 20.dp, start = 45.dp)) {
            Row() {
                Text(
                    text = "Upcoming",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

                Image(
                    painter = painterResource(id = R.drawable.upcoming),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 5.dp, start = 8.dp)
                        .size(25.dp)
                )

            }

            Row() {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    Text(
                        text = start,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row() {

                        Image(
                            painter = painterResource(id = R.drawable.time),
                            contentDescription = null,
                            modifier = Modifier.padding(top = 1.dp)
                        )

                        Spacer(modifier = Modifier.width(20.dp))
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .width(260.dp)
                                .height(60.dp)
                                .border(
                                    width = 3.dp,
                                    color = colorResource(id = R.color.GoogleBlue_Dark),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(top = 12.dp)

                        ) {
                            Text(
                                text = event,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = colorResource(id = R.color.GoogleBlue_Dark),
                                modifier = Modifier.padding(start = 12.dp)
                            )

                        }

                    }

                    Text(
                        text = end,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 12.dp)
                    )


                }


            }


            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .width(150.dp)
                    .height(30.dp)
                    .border(
                        width = 3.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .align(Alignment.End)
            ) {
                Row(modifier = Modifier
                    .align(Alignment.Center)
                    .clickable {
                        navController.navigate(route = Screen.Timeline.route)
                    }) {
                    Text(
                        text = "View Timeline",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,

                        )

                    Image(
                        painter = painterResource(id = R.drawable.view_arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 4.dp, start = 5.dp)
                            .size(9.dp)
                    )

                }
            }
        }

    }

}

@Composable
fun OpenDiscord() {
    val openDiscordUrl: Uri = Uri.parse(Constants.discordLink)
    val intent = Intent(Intent.ACTION_VIEW, openDiscordUrl)
    val context = LocalContext.current

    Card(
        backgroundColor = GreyBackground,
        elevation = 0.dp,
        modifier = Modifier.clickable {
            startActivity(context, intent, null)
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.join_discord), contentDescription = null,
            modifier = Modifier.padding(start = 16.dp)
        )

        Column(modifier = Modifier.padding(top = 50.dp, start = 45.dp)) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = colorResource(id = R.color.JoinDiscordColor),
                            fontSize = 20.sp
                        )
                    ) {
                        append("Join the #")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = GoogleRed,
                            fontSize = 20.sp
                        )
                    ) {
                        append("D")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = GoogleGreen,
                            fontSize = 20.sp
                        )
                    ) {
                        append("J")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = colorResource(id = R.color.JoinDiscordColor),
                            fontSize = 20.sp
                        )
                    ) {
                        append("'2")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = GoogleYellow,
                            fontSize = 20.sp
                        )
                    ) {
                        append("2")
                    }
                },
                fontWeight = FontWeight.Bold
            )

            Row {
                Text(
                    text = "Discord",
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.JoinDiscordColor),
                    fontSize = 20.sp
                )

                Image(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 6.dp, start = 8.dp)
                )

            }

        }

    }
}





