package com.dscvit.devjams22.presentation.announcements

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dscvit.devjams22.R
import com.dscvit.devjams22.common.State
import com.dscvit.devjams22.data.remote.dto.AnnouncementDC
import com.dscvit.devjams22.presentation.components.ProgressBar
import com.dscvit.devjams22.presentation.ui.theme.GreyBackground
import com.dscvit.devjams22.presentation.ui.theme.LockScreenOrientation
import com.yeocak.timelineview.TimelineView
import java.text.SimpleDateFormat


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Announcement(
    viewModel: AnnouncementViewModel = viewModel()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
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
                ProgressBar(isDisplayed = true)
            }

            is State.Success -> {
                LazyColumn {
                    items((postsState as State.Success<List<AnnouncementDC>>).data) {

                        AnnouncementsCard(announcementDC = it)

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

//@Preview
@SuppressLint("SimpleDateFormat")
@Composable
fun AnnouncementsCard(announcementDC: AnnouncementDC) {

    val daySDF = SimpleDateFormat("d MMM")
    val currentDate = announcementDC.time?.toDate()?.let { daySDF.format(it) }


    val timeSDF = SimpleDateFormat("ha")
    val time = announcementDC.time?.toDate()?.let { timeSDF.format(it) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .fillMaxWidth(.85f)
                .fillMaxHeight(.40f)
        ) {

            Column() {
                Text(
                    text = "${announcementDC.title}",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp, bottom = 10.dp, top = 12.dp)
                )

                Row() {
                    Text(
                        text = "${announcementDC.desc}",
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 8.dp, bottom = 12.dp)
                            .weight(1f)
                    )


                    Text(
                        text = "$currentDate $time",
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(
                            top = 5.dp,
                            start = 16.dp,
                            end = 12.dp,
                            bottom = 12.dp
                        ),
                    )


                }

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