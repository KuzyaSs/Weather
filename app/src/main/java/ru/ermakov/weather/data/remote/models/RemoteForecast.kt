package ru.ermakov.weather.data.remote.models

import com.google.gson.annotations.SerializedName

data class RemoteForecast(
    @SerializedName("forecastday")
    val remoteForecastDays: List<RemoteForecastDay>
)