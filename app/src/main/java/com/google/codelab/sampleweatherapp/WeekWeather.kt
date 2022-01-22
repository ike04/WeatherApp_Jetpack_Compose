package com.google.codelab.sampleweatherapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.codelab.sampleweatherapp.data.Weather
import com.google.codelab.sampleweatherapp.ui.theme.CellBackGround
import com.google.codelab.sampleweatherapp.ui.theme.TempHigh
import com.google.codelab.sampleweatherapp.ui.theme.TempLow

@Composable
fun WeekWeather(weathers: List<Weather>) {
    var isExpanded by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
            .background(color = CellBackGround, shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
    ) {
        itemsIndexed(weathers) { index, weather ->
            if (index == 0) {
                Text(
                    text = "Weekly",
                    color = Color.White,
                    style = MaterialTheme.typography.h6,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            when (isExpanded) {
                true -> {
                    DayWeatherCell(weather)
                    Spacer(modifier = Modifier.height(8.dp))
                }
                false -> {
                    if (index < 3) {
                        DayWeatherCell(weather)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
            if (index == weathers.lastIndex) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painterResource(id = if (isExpanded) R.drawable.ic_baseline_expand_less_24 else R.drawable.ic_baseline_expand_more_24),
                        contentDescription = "expand",
                        modifier = Modifier
                            .size(24.dp)
                            .align(alignment = Alignment.BottomCenter)
                            .padding(bottom = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun DayWeatherCell(weather: Weather) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = weather.date,
            color = Color.White,
            modifier = Modifier.padding(start = 24.dp)
        )
        Spacer(modifier = Modifier.width(32.dp))
        Image(
            painterResource(id = weather.image),
            contentDescription = "sunny sometimes cloudy",
            modifier = Modifier
                .size(28.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = weather.high + "℃",
            style = MaterialTheme.typography.body1,
            color = TempHigh
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = weather.low + "℃",
            style = MaterialTheme.typography.body1,
            color = TempLow
        )

        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = weather.rainy + "%",
            color = Color.White,
            style = MaterialTheme.typography.body1
        )
    }
}
