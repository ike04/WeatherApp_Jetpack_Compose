package com.google.codelab.sampleweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.codelab.sampleweatherapp.data.TestData
import com.google.codelab.sampleweatherapp.data.Weather
import com.google.codelab.sampleweatherapp.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleWeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    WeatherApp()
                }
            }
        }
    }
}

@Composable
fun WeatherApp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(BackGround)
    ) {
        TodayWeather(weather = TestData.dayData)
        DayHoursWeather(weather = TestData.hoursData)
        WeekWeather(weathers = TestData.weekData)
    }
}

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
                modifier = Modifier.padding(start = 16.dp)
            )
            Text(
                text = "℃",
                color = TempUnit,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(bottom = 28.dp)
            )
            Spacer(modifier = Modifier.width(200.dp))
//            Image(
//                painterResource(id = weather.image),
//                contentDescription = "",
//                modifier = Modifier
//                    .size(80.dp)
//                    .padding(end = 16.dp)
//            )
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(weather.image))
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.size(80.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Cloudy",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 16.dp)
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
                    .padding(start = 16.dp)
            )
            Text(
                text = "Tokyo",
                color = Color.White,
                fontSize = 12.sp
            )
        }

    }
}

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

@Composable
fun WeekWeather(weathers: List<Weather>) {
    var isExpanded by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .padding(all = 16.dp)
            .background(color = CellBackGround, shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
    ) {
        itemsIndexed(weathers) { index, weather ->
            if (index == 0) {
                Text(
                    text = "Weekly", color = Color.White,
                    style = MaterialTheme.typography.h6,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            when (isExpanded) {
                true -> {
                    DayWeatherCell(weather)
                    Spacer(modifier = Modifier.height(8.dp))
                }
                false ->{
                    if(index < 3) {
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleWeatherAppTheme {
        WeatherApp()
    }
}
