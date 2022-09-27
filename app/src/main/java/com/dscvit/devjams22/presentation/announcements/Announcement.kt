package com.dscvit.devjams22.presentation.announcements

import android.annotation.SuppressLint
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
import com.dscvit.devjams22.data.remote.dto.AnnouncementDC
import com.dscvit.devjams22.presentation.ui.theme.GreyBackground
import com.yeocak.timelineview.TimelineView


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Announcement(

    viewModel: AnnouncementViewModel = viewModel()
) {

    val postsState: State<List<AnnouncementDC>> by viewModel.postState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground)
            .padding(bottom = 10.dp)

    ) {
        Text(
            text = "Announcement",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp, bottom = 20.dp)
        )

        when (postsState) {
            is State.Loading -> {
                Text(text = "Loading")
            }

            is State.Success -> {

                Log.d(
                    "announce",
                    (postsState as State.Success<List<AnnouncementDC>>).data.toString()
                )

                LazyColumn {
                    items((postsState as State.Success<List<AnnouncementDC>>).data) {
                        EachEventWithHead(announcementDC = it)

                    }
                }

            }

            is State.Failed -> {
                Text(text = (postsState as State.Failed<List<AnnouncementDC>>).message)
                Log.d("Failed", (postsState as State.Failed<List<AnnouncementDC>>).message)
            }
        }


    }


}


@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EachEventWithHead(announcementDC: AnnouncementDC) {


    Row(
        modifier = Modifier
            .padding(start = 32.dp)
            .height(IntrinsicSize.Min)
    ) {
        TimelineView.SingleNode(
            color = colorResource(
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
                    text = "${announcementDC.title}",
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(
                        id = R.color.timelineDayColor
                    ),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp, bottom = 10.dp, top = 12.dp)
                )

                Text(
                    text = "${announcementDC.desc}",
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(
                        id = R.color.timelineColor
                    ),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                )

            }
        }


    }


}