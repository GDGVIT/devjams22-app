package com.dscvit.devjams22.presentation.home.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.dscvit.devjams22.R
import com.dscvit.devjams22.common.Constants
import com.dscvit.devjams22.presentation.ui.theme.GoogleGreen
import com.dscvit.devjams22.presentation.ui.theme.GoogleRed
import com.dscvit.devjams22.presentation.ui.theme.GoogleYellow
import com.dscvit.devjams22.presentation.ui.theme.GreyBackground


@Preview(showSystemUi = true)
@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 32.dp, start = 32.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_person_24),
                contentDescription = "blimp",
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
                    .border(
                        width = 10.dp,
                        color = colorResource(id = R.color.blue_button),
                        shape = CircleShape
                    )
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Hey",
                modifier = Modifier.padding(top = 10.dp),
                style = MaterialTheme.typography.h3,
                fontSize = 25.sp,
                color = colorResource(id = R.color.heyColor)

            )

            Spacer(modifier = Modifier.width(8.dp))


            Text(
                text = "User!",
                modifier = Modifier.padding(top = 10.dp),
                style = MaterialTheme.typography.body1,
                fontSize = 25.sp,
                color = colorResource(id = R.color.nameColor)

            )

            Spacer(modifier = Modifier.width(120.dp))

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


    }
}





