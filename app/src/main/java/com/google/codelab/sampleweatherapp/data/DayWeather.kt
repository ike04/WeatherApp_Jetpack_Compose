package com.google.codelab.sampleweatherapp.data

import com.google.codelab.sampleweatherapp.R

data class Location(
    val name: String,
    val weather: Weather
)

data class Weather(
    val date: String,
    val image: Int,
    val high: String,
    val low: String,
    val rainy: String,
    val name: String? = null
)

object TestData {
    private val dayData1 = Weather("Mon, 1 Feb", R.raw.sunny_and_rainny, "20", "16", "50", "rainy")
    private val dayData2 = Weather("Mon, 1 Feb", R.raw.sunny, "22", "19", "10", "sunny")
    private val dayData3 = Weather("Mon, 1 Feb", R.raw.snow, "8", "3", "80", "snow")
    private val tokyo = Location("Tokyo", dayData1)
    private val chiba = Location("Chiba", dayData2)
    private val osaka = Location("Osaka", dayData3)
    val weatherList = listOf(tokyo, chiba, osaka)

    val hoursData = listOf(
        Weather("10", R.drawable.sunny_and_cloudy, "23", "16", "50"),
        Weather("11", R.drawable.sunny_and_cloudy, "18", "14", "60"),
        Weather("12", R.drawable.rainy, "16", "15", "90"),
        Weather("13", R.drawable.rainy, "21", "18", "90"),
        Weather("14", R.drawable.thunder, "20", "6", "100"),
        Weather("15", R.drawable.rainy, "23", "16", "100"),
        Weather("16", R.drawable.sunny_and_cloudy, "18", "14", "50"),
        Weather("17", R.drawable.sunny_and_cloudy, "16", "15", "30"),
        Weather("18", R.drawable.cloudy_and_moon, "21", "18", "20"),
        Weather("19", R.drawable.cloudy_and_moon, "17", "10", "0"),
        Weather("20", R.drawable.cloudy_and_moon, "17", "10", "0"),
        Weather("21", R.drawable.rainy_and_moon, "12", "9", "80"),
        Weather("22", R.drawable.rainy_and_moon, "13", "8", "60"),
        Weather("23", R.drawable.rainy_and_moon, "11", "10", "80"),
        Weather("24", R.drawable.moon, "15", "11", "20")
    )

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
        Weather("2/11（木）", R.drawable.thunder, "17", "10", "100"),
        Weather("2/12（金）", R.drawable.thunder, "12", "8", "80"),
        Weather("2/13（土）", R.drawable.rainy, "11", "7", "70")
    )
}
