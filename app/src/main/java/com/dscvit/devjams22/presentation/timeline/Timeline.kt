package com.dscvit.devjams22.presentation.timeline

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dscvit.devjams22.R
import com.dscvit.devjams22.presentation.ui.theme.GreyBackground
import com.yeocak.timelineview.TimelineView

@Preview(showSystemUi = true)
@Composable
fun Timeline() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 70.dp)
    ) {
        Text(
            text = "Timeline",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp)
        )

        Row(modifier = Modifier
            .padding(start = 32.dp, top = 20.dp)
            .height(IntrinsicSize.Min)) {
            TimelineView.SingleNode(
                color = colorResource(id = R.color.timelineColor),
                nodeType = TimelineView.NodeType.MIDDLE,
                nodeSize = 60f,
                isChecked = false,
                isDashed = false,

            )




                Box(modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()){
                    Column() {
                        Text(
                            text = "Day 1 - 30th Oct",
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = R.color.timelineDayColor),
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        Text(
                            text = "9am - Opening Ceremony",
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = R.color.timelineColor),
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start = 16.dp, top = 10.dp)
                        )

                    }
                }



        }

        Row(modifier = Modifier
            .padding(start = 32.dp)
            .height(IntrinsicSize.Min)) {
            TimelineView.SingleNode(
                color = colorResource(id = R.color.timelineColor),
                nodeType = TimelineView.NodeType.MIDDLE,
                nodeSize = 60f,
                isChecked = false,
                isDashed = false,

            )

            Box(modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()){
                Text(
                    text = "12pm - Hackathon Begins",
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.timelineColor),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp, top = 35.dp)
                )
            }

        }


    }

}