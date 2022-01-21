package com.google.codelab.sampleweatherapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.codelab.sampleweatherapp.data.Weather
import com.google.codelab.sampleweatherapp.ui.theme.CellBackGround
import com.google.codelab.sampleweatherapp.ui.theme.TempUnit

@Composable
fun TodayWeather(weather: Weather) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
            .background(color = CellBackGround, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        {
            Text(
                text = "Today",
                color = Color.White,
                style = MaterialTheme.typography.h6,
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.width(220.dp))
            Text(
                text = weather.date,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .align(alignment = Alignment.Bottom)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = weather.high,
                color = Color.White,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(start = 24.dp)
            )
            Text(
                text = "℃",
                color = TempUnit,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(bottom = 28.dp)
            )
            Spacer(modifier = Modifier.width(200.dp))

            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(weather.image))
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.size(80.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Rainy",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 24.dp)
            )
            Spacer(modifier = Modifier.width(240.dp))

            Image(
                painterResource(id = R.drawable.umbrella),
                contentDescription = "rainy percent",
                modifier = Modifier
                    .size(28.dp)
                    .padding(end = 4.dp)
            )
            Text(
                text = weather.rainy + "%",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(end = 16.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(id = R.drawable.location),
                contentDescription = "current location",
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 24.dp)
            )
            Text(
                text = "Tokyo",
                color = Color.White,
                fontSize = 12.sp
            )
        }

    }
}
