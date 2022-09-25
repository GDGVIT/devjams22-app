package com.dscvit.devjams22.presentation.info.components

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.dscvit.devjams22.R
import com.dscvit.devjams22.common.Constants
import com.dscvit.devjams22.presentation.home.components.OpenDiscord
import com.dscvit.devjams22.presentation.ui.theme.*


@Preview(showSystemUi = true)
@Composable
fun Info() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 70.dp)
    ) {
        Text(
            text = "Sponsors",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Sponsor()

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "FAQ",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))
        Faq()

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Contact Us",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OpenDiscord()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Socials()

        }

    }

}


@Composable
fun Sponsor() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.digitalocean),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .align(CenterVertically)

        )

        Image(
            painter = painterResource(id = R.drawable.hashicorp),
            contentDescription = null,
            modifier = Modifier
                .size(102.dp)
                .align(CenterVertically)
                .padding(top = 5.dp)

        )
        Image(
            painter = painterResource(id = R.drawable.deepnote),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .align(CenterVertically)
                .padding(top = 0.dp)

        )
        Image(
            painter = painterResource(id = R.drawable.echoar),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .align(CenterVertically)
                .padding(top = 0.dp)

        )
    }

    Spacer(modifier = Modifier.height(5.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.voiceflow),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .align(CenterVertically)
                .padding(top = 0.dp)

        )

        Image(
            painter = painterResource(id = R.drawable.ren),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .align(CenterVertically)
                .padding(start = 10.dp)

        )

    }
}

@Composable
fun Faq() {
    ExpandanbleFAQCard(
        stringResource(id = R.string.q_1),
        stringResource(id = R.string.a_1),
        GoogleRed
    )
    ExpandanbleFAQCard(
        stringResource(id = R.string.q_2),
        stringResource(id = R.string.a_2),
        GoogleBlue
    )
    ExpandanbleFAQCard(
        stringResource(id = R.string.q_3),
        stringResource(id = R.string.a_3),
        GoogleGreen
    )
    ExpandanbleFAQCard(
        stringResource(id = R.string.q_4),
        stringResource(id = R.string.a_4),
        GoogleYellow
    )
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandanbleFAQCard(title: String, description: String, color: Color) {

    var expandedState by remember { mutableStateOf(false) }

    Card(
        onClick = { expandedState = !expandedState }, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .animateContentSize(
                animationSpec = tween(
                    400,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.small,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 0.dp)
        ) {
            Row(verticalAlignment = CenterVertically) {
                Text(
                    text = title,
                    modifier = Modifier.weight(6f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = color,
                    overflow = TextOverflow.Ellipsis,

                )
                IconButton(
                    onClick = { expandedState != expandedState },
                    modifier = Modifier
                        .weight(1f)
                        .alpha(.5f)
                ) {

                }
                if (!expandedState) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                        contentDescription = null,
                        tint = color,
                        modifier = Modifier.size(20.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_up_24),
                        contentDescription = null,
                        tint = color,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            if (expandedState) {
                Text(
                    text = description, fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 40.dp),
                    lineHeight = 18.sp
                )

            }

        }

    }


}

@Composable
fun Socials() {

    val openInstagramUrl: Uri = Uri.parse(Constants.instagramLink)
    val intent = Intent(Intent.ACTION_VIEW, openInstagramUrl)
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .width(120.dp)
            .height(88.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = colorResource(id = R.color.GoogleRed_Light))
            .clickable {
                ContextCompat.startActivity(context, intent, null)

            }
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.instagram), contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "@gdscvitvellore",
                    color = Color.White,
                    fontSize = 12.sp
                )

            }

        }

    }


    val openTwitterUrl: Uri = Uri.parse(Constants.twitterLink)
    val tIintent = Intent(Intent.ACTION_VIEW, openTwitterUrl)
    val tContext = LocalContext.current

    Box(
        modifier = Modifier
            .width(120.dp)
            .height(88.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = colorResource(id = R.color.GoogleYellow_Lighter))
            .clickable {
                ContextCompat.startActivity(tContext, tIintent, null)

            }
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.twitter), contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "@gdscvit",
                    color = Color.White,
                    fontSize = 12.sp
                )

            }

        }

    }


    val openMailUrl: Uri = Uri.parse(Constants.mailLink)
    val mIntent = Intent(Intent.ACTION_VIEW, openMailUrl)
    val mContext = LocalContext.current

    Box(
        modifier = Modifier
            .width(120.dp)
            .height(88.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = colorResource(id = R.color.GoogleGreen_Lighter))
            .clickable {
                ContextCompat.startActivity(mContext, mIntent, null)

            }
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.mail), contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "dscvit@gmail.com",
                    color = Color.White,
                    fontSize = 12.sp
                )

            }

        }

    }

}
