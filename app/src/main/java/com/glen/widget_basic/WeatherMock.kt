package com.glen.widget_basic

import kotlin.random.Random

object WeatherMock {

    private val weathers = mutableListOf(
        getWeatherInfo("Seoul"),
        getWeatherInfo("New York"),
        getWeatherInfo("London"),
        getWeatherInfo("Paris")
    )
    var region: String = "Seoul"

    fun getWeather(): WeatherInfo = weathers.find { it.region == this.region } ?: weathers.first()

    fun updateWeather() {
        weathers.clear()
        weathers.addAll(
            listOf(
                getWeatherInfo("Seoul"),
                getWeatherInfo("New York"),
                getWeatherInfo("London"),
                getWeatherInfo("Paris")
            )
        )
    }

    private fun getWeatherInfo(region: String): WeatherInfo {
        val temperature = Random.nextInt(0, 30)
        return WeatherInfo(
            region = region,
            type = getWeatherType(),
            temperature = "${temperature}°",
            amTemperature = "${temperature - 4}°",
            pmTemperature = "${temperature + 2}°",
            expectedTemperature1 = "${temperature - 1}°",
            expectedWeatherType1 = getWeatherType(),
            expectedTemperature2 = "${temperature}°",
            expectedWeatherType2 = getWeatherType(),
            expectedTemperature3 = "${temperature - 2}°",
            expectedWeatherType3 = getWeatherType()
        )
    }

    private fun getWeatherType(): WeatherType {
        return when (Random.nextInt() % 4) {
            0 -> WeatherType.SUNNY
            1 -> WeatherType.MOSTLY_CLOUDY
            2 -> WeatherType.CLOUDY
            else -> WeatherType.RAINY
        }
    }
}
