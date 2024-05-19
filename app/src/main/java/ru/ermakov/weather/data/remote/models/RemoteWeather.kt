package ru.ermakov.weather.data.remote.models

import com.google.gson.annotations.SerializedName

data class RemoteWeather(
    @SerializedName("location")
    val remoteLocation: RemoteLocation,
    @SerializedName("current")
    val remoteCurrentForecast: RemoteCurrentForecast,
    @SerializedName("forecast")
    val remoteForecast: RemoteForecast
)