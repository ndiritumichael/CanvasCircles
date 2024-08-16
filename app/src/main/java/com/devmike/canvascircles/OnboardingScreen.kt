package com.devmike.canvascircles

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devmike.canvascircles.ui.theme.CanvasCirclesTheme

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onSignupClick: () -> Unit
){

    val devicemeasure = LocalConfiguration.current
    val height  = devicemeasure.screenHeightDp.dp
    val width = devicemeasure.screenWidthDp.dp
    Box(modifier = Modifier
        .fillMaxSize()
        .drawBehind {

            //top circle
            drawCircle(
                radius = width.toPx(),
                color =  Color(0xFF003153),
                center = Offset((width).toPx(), -75.dp.toPx())

            )

            //bottom circle
            drawCircle(
                radius = width.toPx(),
                color =  Color(0xFF003153),
                center = Offset((width * 1.5f).toPx(), (height * 0.35f).toPx())

            )

            //large dark circle
            drawCircle(
                color = Color(0xFF1C3742)
                , radius = 100f,
                center =  Offset((width/2).toPx(),25f )
            )
           // medium dark circle
            drawCircle(
                color = Color(0xFF1C3742)
                , radius = 50f,
                center =  Offset( (width *0.7f).toPx(),  (height / 10).toPx() )
            )
            drawCircle(
                color = Color(0xFF1C3742)
                , radius = 30f,
                center =  Offset((width/2).toPx(),(height*0.25f).toPx()  )
            )

        }
        .padding(8.dp)){

        Image(painter = painterResource(id = R.drawable.mansmiling)
            , contentDescription = "centre image",
            modifier = Modifier
                .padding(end = width / 6, top = height / 10)
                .size(100.dp)
                .clip(CircleShape)
                .align(Alignment.TopEnd)

            ,
            contentScale = ContentScale.FillHeight)

        Image(painter = painterResource(id = R.drawable.centerimage)
            , contentDescription = "centre image",
            modifier = Modifier
                .padding(bottom = height / 4)
                .size(200.dp)

                .clip(CircleShape)
                .align(Alignment.Center)
                ,
            contentScale = ContentScale.FillHeight)

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .fillMaxHeight(0.4f)
            .align(Alignment.BottomCenter), verticalArrangement = Arrangement.spacedBy(16.dp)) {
Text(text = "Crypto Payments \nmade Easy",style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold )
            Text(text = "Make payments for your day to day\npurchases directly from your wallet")
            Spacer(modifier =  Modifier.height(16.dp))

            Button(onClick = onSignupClick, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp)) {
                Text(text = "Get Started",modifier = Modifier

                    .padding(vertical = 8.dp))
            }

        }



    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
   CanvasCirclesTheme {
       Surface {


           WelcomeScreen() {

           }
       }
   }
}