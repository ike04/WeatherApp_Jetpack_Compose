package com.google.codelab.sampleweatherapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.codelab.sampleweatherapp.data.Weather
import com.google.codelab.sampleweatherapp.ui.theme.CellBackGround

@Composable
fun DayHoursWeather(weather: List<Weather>) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(all = 16.dp)
            .background(color = CellBackGround, shape = RoundedCornerShape(16.dp))
    ) {
        items(weather) { weather ->
            HourWeatherCell(weather)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun HourWeatherCell(weather: Weather) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { }
            .padding(all = 8.dp)
    ) {
        Text(
            text = weather.date,
            color = Color.White,
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(4.dp))
        Image(
            painterResource(id = weather.image),
            contentDescription = "sunny sometimes cloudy",
            modifier = Modifier
                .size(40.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = weather.high + "℃",
            style = MaterialTheme.typography.body1,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))


        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = weather.rainy + "%",
            color = Color.White,
            style = MaterialTheme.typography.body1
        )
    }
}
