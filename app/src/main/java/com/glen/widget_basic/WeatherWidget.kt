package com.glen.widget_basic

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

/**
 * Implementation of App Widget functionality.
 */
class WeatherWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        WeatherMock.updateWeather()
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onAppWidgetOptionsChanged(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int,
        newOptions: Bundle?,
    ) {
        updateAppWidget(context, appWidgetManager, appWidgetId, newOptions)
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
    newOptions: Bundle? = null
) {
    val weatherInfo = WeatherMock.getWeather()

    // Construct the RemoteViews object
    val widgetOptions = newOptions ?: appWidgetManager.getAppWidgetOptions(appWidgetId)
    val remoteView = if (widgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT) < 120) {
        RemoteViews(context.packageName, R.layout.weather_widget_small).apply {
            setTextViewText(R.id.region_name, weatherInfo.region)
            setImageViewResource(R.id.today_weather_icon, weatherInfo.type.drawableRes)
            setTextViewText(R.id.today_temperature, weatherInfo.temperature)
            setTextViewText(R.id.am_temperature, weatherInfo.amTemperature)
            setTextViewText(R.id.pm_temperature, weatherInfo.pmTemperature)
        }
    } else {
        val dateFormat = SimpleDateFormat("h a", Locale.US)
        RemoteViews(context.packageName, R.layout.weather_widget_big).apply {
            setTextViewText(R.id.region_name, weatherInfo.region)
            setTextViewText(R.id.today_weather_description, weatherInfo.type.description)
            setImageViewResource(R.id.today_weather_icon, weatherInfo.type.drawableRes)
            setTextViewText(R.id.today_temperature, weatherInfo.temperature)
            setTextViewText(R.id.am_temperature, weatherInfo.amTemperature)
            setTextViewText(R.id.pm_temperature, weatherInfo.pmTemperature)
            setTextViewText(R.id.expected_temperature_1, weatherInfo.expectedTemperature1)
            setImageViewResource(R.id.expected_icon_1, weatherInfo.expectedWeatherType1.drawableRes)
            setTextViewText(R.id.expected_time_1, dateFormat.format(Date().apply { hours += 1 }))
            setTextViewText(R.id.expected_temperature_2, weatherInfo.expectedTemperature2)
            setImageViewResource(R.id.expected_icon_2, weatherInfo.expectedWeatherType2.drawableRes)
            setTextViewText(R.id.expected_time_2, dateFormat.format(Date().apply { hours += 2 }))
            setTextViewText(R.id.expected_temperature_3, weatherInfo.expectedTemperature3)
            setImageViewResource(R.id.expected_icon_3, weatherInfo.expectedWeatherType3.drawableRes)
            setTextViewText(R.id.expected_time_3, dateFormat.format(Date().apply { hours += 3 }))
        }
    }

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, remoteView)
}
