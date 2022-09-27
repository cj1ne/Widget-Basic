package com.glen.widget_basic

data class WeatherInfo(
    val region: String,
    val type: WeatherType,
    val temperature: String,
    val amTemperature: String,
    val pmTemperature: String,
    val expectedTemperature1: String,
    val expectedWeatherType1: WeatherType,
    val expectedTemperature2: String,
    val expectedWeatherType2: WeatherType,
    val expectedTemperature3: String,
    val expectedWeatherType3: WeatherType
)
