package com.google.codelab.sampleweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.codelab.sampleweatherapp.data.TestData
import com.google.codelab.sampleweatherapp.ui.theme.BackGround
import com.google.codelab.sampleweatherapp.ui.theme.SampleWeatherAppTheme

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleWeatherAppTheme {
        WeatherApp()
    }
}
