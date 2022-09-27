package com.glen.widget_basic

import androidx.annotation.DrawableRes

enum class WeatherType(val description: String, @DrawableRes val drawableRes: Int) {
    SUNNY("Sunny", R.drawable.ic_weather_sunny),
    MOSTLY_CLOUDY("Mostly cloudy", R.drawable.ic_weather_mostly_cloudy),
    CLOUDY("Cloudy", R.drawable.ic_weather_cloudy),
    RAINY("Rainy", R.drawable.ic_weather_rainy);
}
