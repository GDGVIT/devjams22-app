package com.dscvit.devjams22.presentation.home.components

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dscvit.devjams22.R
import com.dscvit.devjams22.common.Constants
import com.dscvit.devjams22.common.State
import com.dscvit.devjams22.data.remote.dto.AnnouncementDC
import com.dscvit.devjams22.data.remote.dto.TimelineDC
import com.dscvit.devjams22.presentation.announcements.AnnouncementViewModel
import com.dscvit.devjams22.presentation.navigation.Screen
import com.dscvit.devjams22.presentation.timeline.EventsViewModel
import com.dscvit.devjams22.presentation.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
@Composable
fun Home(
    navController: NavController,
    viewModel: EventsViewModel = viewModel(),
    viewModelAnnounce: AnnouncementViewModel = viewModel()
) {

    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


    val scaffoldState = rememberScaffoldState()
    val postsState: State<List<TimelineDC>> by viewModel.postState.collectAsState()
    val announcePostsState: State<List<AnnouncementDC>> by viewModelAnnounce.postState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        snackbarHost = { scaffoldState.snackbarHostState }) {


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


            }

            Spacer(modifier = Modifier.height(16.dp))

            OpenDiscord()
            val context = LocalContext.current

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier.align(CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hashtag), contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            //navController.navigate(route = Screen.Hashtag.route)
                            mToast(context)


                        }
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
                    TimelineCard(
                        navController,
                        "Loading",
                        "",
                        ""
                    )
                }

                //timeline
                is State.Success -> {

                    for (event in (postsState as State.Success<List<TimelineDC>>).data) {
                        val eventSDF = SimpleDateFormat("yyyy.MM.dd G HH:mm:ss z")
                        val eventTimeAndDateStart =
                            event.startTime?.toDate()?.let { eventSDF.format(it) }

                        val startTimeSDF = SimpleDateFormat("ha")
                        val startTime = event.startTime?.toDate()?.let { startTimeSDF.format(it) }

                        val endTimeSDF = SimpleDateFormat("ha")
                        val endTime = event.endTime?.toDate()?.let { endTimeSDF.format(it) }

                        if (getCurrentTimeAndDate < eventTimeAndDateStart!! && event.endTime != null) {
                            TimelineCard(
                                navController,
                                event.eventName.toString(),
                                startTime.toString(),
                                endTime.toString()
                            )
                            break
                        } else if ((getCurrentTimeAndDate < eventTimeAndDateStart && event.endTime == null)) {
                            TimelineCard(
                                navController,
                                event.eventName.toString(),
                                startTime.toString(),
                                ""
                            )
                            break

                        } else {
                            val lastItem =
                                getLast((postsState as State.Success<List<TimelineDC>>).data)

                            if (lastItem?.endTime == null) {
                                TimelineCard(
                                    navController,
                                    event.eventName.toString(),
                                    startTime.toString(),
                                    ""
                                )
                                break
                            } else {
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

                }

                is State.Failed -> {

                    TimelineCard(
                        navController,
                        "Check your network connection",
                        "",
                        ""
                    )

                    Log.d("Failed", (postsState as State.Failed<List<TimelineDC>>).message)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            //announcements
            when (announcePostsState) {
                is State.Loading -> {
                    Announcements(navController, "Loading", "")
                }

                is State.Success -> {

                    for (event in (announcePostsState as State.Success<List<AnnouncementDC>>).data) {
                        val eventSDF = SimpleDateFormat("yyyy.MM.dd G HH:mm:ss z")
                        val eventTimeAndDateStart =
                            event.time?.toDate()?.let { eventSDF.format(it) }

                        if (getCurrentTimeAndDate <= eventTimeAndDateStart!!) {
                            Announcements(
                                navController,
                                event.title.toString(),
                                event.desc.toString()
                            )
                            break
                        } else {
                            val lastItem =
                                getLast((announcePostsState as State.Success<List<AnnouncementDC>>).data)

                            Announcements(
                                navController,
                                lastItem?.title.toString(), lastItem?.desc.toString()
                            )
                            break


                        }

                    }

                }

                is State.Failed -> {
                    Announcements(
                        navController = navController,
                        title = "Check your network connection",
                        desc = ""
                    )
                    Log.d(
                        "Failed",
                        (announcePostsState as State.Failed<List<AnnouncementDC>>).message
                    )
                }
            }


        }

    }


}


@Composable
fun Announcements(navController: NavController, title: String, desc: String) {

    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .padding(start = 22.dp, end = 22.dp)
            .height(200.dp)
            .background(Color.White)
    ) {

        Column(modifier = Modifier.padding(top = 20.dp, start = 45.dp)) {
            Row() {
                Text(
                    text = "Announcements",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )


            }

            Row() {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    Row() {

                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .width(300.dp)
                                .height(60.dp)
                                .padding(top = 12.dp)

                        ) {

                            Row() {

                                Image(
                                    painter = painterResource(id = R.drawable.circle),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(top = 1.dp, start = 0.dp)
                                        .size(35.dp)
                                )

                                Column() {
                                    Text(
                                        text = title,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = Color.Black,
                                        modifier = Modifier.padding(start = 12.dp)
                                    )
                                    Text(
                                        text = desc,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 13.sp,
                                        color = Color.Black,
                                        modifier = Modifier.padding(start = 12.dp)
                                    )

                                }


                            }


                        }

                    }


                }


            }

            Spacer(modifier = Modifier.height(12.dp))


            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .width(150.dp)
                    .height(30.dp)
                    .border(
                        width = 3.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(20.dp)
                    )

                    .align(Alignment.End)
            ) {

                Row(
                    modifier = Modifier
                        .align(Alignment.Center)
                ) {

                    Row(
                        modifier = Modifier

                            .clickable {
                                navController.navigate(route = Screen.Announcement.route)
                            }
                    ) {
                        Text(
                            text = "View Announcements",
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,

                            )

                        Image(
                            painter = painterResource(id = R.drawable.arrow_black),
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

            Spacer(modifier = Modifier.height(8.dp))
        }

    }

}

@Composable
fun OpenDiscord() {
    val openDiscordUrl: Uri = Uri.parse(Constants.discordLink)
    val intent = Intent(Intent.ACTION_VIEW, openDiscordUrl)
    val context = LocalContext.current

    Box(
        modifier = Modifier

            .background(GreyBackground)


    ) {
        Image(
            painter = painterResource(id = R.drawable.join_discord), contentDescription = null,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
                .clickable {
                    ContextCompat.startActivity(context, intent, null)

                }


        )

        Column(modifier = Modifier.padding(top = 30.dp, start = 45.dp)) {
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

private fun mToast(context: Context) {
    Toast.makeText(context, "Coming Soon!", Toast.LENGTH_LONG).show()
}

fun <T> getLast(list: List<T>): T? {
    var lastItem: T? = null
    for (e in list) {
        lastItem = e
    }
    return lastItem
}






