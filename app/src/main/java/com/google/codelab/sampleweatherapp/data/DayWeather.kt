package com.google.codelab.sampleweatherapp.data

import com.google.codelab.sampleweatherapp.R

//enum class DayWeather(@IdRes val image: Int, val high: String, val low: String, val rainy: String) {
//    Day1(R.drawable.sunny_and_cloudy, "20", "16", "30"),
//    Day2(R.drawable.sunny, "23", "16", "10"),
//    Day3(R.drawable.rainy, "18", "14", "80"),
//    Day4(R.drawable.sunny_and_cloudy, "16", "15", "50"),
//    Day5(R.drawable.sunny, "21", "18", "10");
//}

data class Weather(
    val date: String,
    val image: Int,
    val high: String,
    val low: String,
    val rainy: String
)

object TestData {
    val dayData = Weather("Mon, 1 Feb", R.drawable.sunny_and_cloudy, "20", "16", "50")

    val weekData = listOf(
        Weather("2/2（火）", R.drawable.sunny, "23", "16", "10"),
        Weather("2/3（水）", R.drawable.rainy, "18", "14", "80"),
        Weather("2/4（木）", R.drawable.thunder, "16", "15", "50"),
        Weather("2/5（金）", R.drawable.sunny, "21", "18", "10"),
        Weather("2/6（土）", R.drawable.sunny_and_cloudy, "20", "16", "30"),
        Weather("2/7（日）", R.drawable.sunny, "23", "16", "10"),
        Weather("2/8（月）", R.drawable.rainy, "18", "14", "80"),
        Weather("2/9（火）", R.drawable.sunny_and_cloudy, "16", "15", "50"),
        Weather("2/10（水）", R.drawable.sunny, "21", "18", "10"),
        Weather("2/11（木）", R.drawable.thunder, "17", "10", "100")
    )
}
