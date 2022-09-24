package com.dscvit.devjams22.presentation.timeline

import android.util.Log
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
import com.dscvit.devjams22.presentation.ui.theme.GreyBackground
import com.yeocak.timelineview.TimelineView


@Composable
fun Timeline(

    viewModel: EventsViewModel = viewModel()
) {

    val postsState: State<List<TimelineDC>> by viewModel.postState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground)

    ) {
        Text(
            text = "Timeline",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp)
        )

        when (postsState) {
            is State.Loading -> {
                Text(text = "Loading")
            }

            is State.Success -> {

                LazyColumn {
                    items((postsState as State.Success<List<TimelineDC>>).data) {
                        EachEvent(timelineDC = it)
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
fun EachEvent(timelineDC: TimelineDC) {
    Row(
        modifier = Modifier
            .padding(start = 32.dp, top = 20.dp)
            .height(IntrinsicSize.Min)
    ) {
        TimelineView.SingleNode(
            color = colorResource(id = R.color.timelineColor),
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
//                Text(
//                    text = "Day 1 - 30th Oct",
//                    fontWeight = FontWeight.SemiBold,
//                    color = colorResource(id = R.color.timelineDayColor),
//                    fontSize = 18.sp,
//                    modifier = Modifier.padding(start = 16.dp, bottom = 10.dp)
//                )
                Text(
                    text = "${timelineDC.startTime?.toDate()} - ${timelineDC.eventName}",
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.timelineColor),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )

            }
        }


    }


}