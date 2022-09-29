package com.dscvit.devjams22.presentation.timeline

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dscvit.devjams22.R
import com.dscvit.devjams22.common.State
import com.dscvit.devjams22.data.remote.dto.TimelineDC
import com.dscvit.devjams22.presentation.components.ProgressBar
import com.dscvit.devjams22.presentation.ui.theme.GreyBackground
import com.dscvit.devjams22.presentation.ui.theme.LockScreenOrientation
import com.yeocak.timelineview.TimelineView
import java.text.SimpleDateFormat
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Timeline(

    viewModel: EventsViewModel = viewModel()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val postsState: State<List<TimelineDC>> by viewModel.postState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground)
            .padding(bottom = 10.dp)

    ) {
        Text(
            text = "Timeline",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp, bottom = 20.dp)
        )

        when (postsState) {
            is State.Loading -> {
                ProgressBar(isDisplayed = true)
            }

            is State.Success -> {

                LazyColumn {
                    items((postsState as State.Success<List<TimelineDC>>).data) {
                        if (it.newDay == true) {
                            EachEventWithHead(timelineDC = it)
                        } else {
                            EachEvent(timelineDC = it)
                        }

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


@SuppressLint("SimpleDateFormat")
@Composable
fun EachEvent(timelineDC: TimelineDC) {

    val daySDF = SimpleDateFormat("d MMM")
    val currentDate = timelineDC.startTime?.toDate()?.let { daySDF.format(it) }
    Log.d("date: ", currentDate.toString())

    val timeSDF = SimpleDateFormat("ha")
    val time = timelineDC.startTime?.toDate()?.let { timeSDF.format(it) }


    val timeNow = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
    val getCurrentTimeAndDate = timeNow.format(Date())

    val eventSDF = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
    val eventTimeAndDate = timelineDC.startTime?.toDate()?.let { eventSDF.format(it) }



    Row(
        modifier = Modifier
            .padding(start = 32.dp)
            .height(IntrinsicSize.Min)
    ) {
        TimelineView.SingleNode(
            color = if (getCurrentTimeAndDate < eventTimeAndDate!!) colorResource(id = R.color.timeLineInactive) else colorResource(
                id = R.color.timelineColor
            ),
            nodeType = TimelineView.NodeType.MIDDLE,
            nodeSize = 40f,
            isChecked = false,
            isDashed = false,

            )

        Box(
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
        ) {
            Column() {
                Text(
                    text = "$time - ${timelineDC.eventName}",
                    fontWeight = FontWeight.SemiBold,
                    color = if (getCurrentTimeAndDate < eventTimeAndDate) colorResource(id = R.color.timeLineInactive) else colorResource(
                        id = R.color.timelineColor
                    ),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 47.dp)
                )

            }
        }


    }


}


@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EachEventWithHead(timelineDC: TimelineDC) {
    val daySDF = SimpleDateFormat("d MMM")
    val currentDate = timelineDC.startTime?.toDate()?.let { daySDF.format(it) }
    Log.d("date: ", currentDate.toString())

    val timeSDF = SimpleDateFormat("ha")
    val time = timelineDC.startTime?.toDate()?.let { timeSDF.format(it) }


    val timeNow = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
    val getCurrentTimeAndDate = timeNow.format(Date())

    val eventSDF = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
    val eventTimeAndDate = timelineDC.startTime?.toDate()?.let { eventSDF.format(it) }

    Row(
        modifier = Modifier
            .padding(start = 32.dp)
            .height(IntrinsicSize.Min)
    ) {
        TimelineView.SingleNode(
            color = if (getCurrentTimeAndDate < eventTimeAndDate!!) colorResource(id = R.color.timeLineInactive) else colorResource(
                id = R.color.timelineColor
            ),
            nodeType = TimelineView.NodeType.MIDDLE,
            nodeSize = 40f,
            isChecked = false,
            isDashed = false,
        )

        Box(
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
        ) {
            Column() {


                Text(
                    text = "Day ${timelineDC.day} - $currentDate",
                    fontWeight = FontWeight.SemiBold,
                    color = if (getCurrentTimeAndDate < eventTimeAndDate) colorResource(id = R.color.timeLineInactive) else colorResource(
                        id = R.color.timelineDayColor
                    ),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp, bottom = 10.dp, top = 12.dp)
                )

                Text(
                    text = "$time - ${timelineDC.eventName}",
                    fontWeight = FontWeight.SemiBold,
                    color = if (getCurrentTimeAndDate < eventTimeAndDate) colorResource(id = R.color.timeLineInactive) else colorResource(
                        id = R.color.timelineColor
                    ),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                )

            }
        }


    }


}