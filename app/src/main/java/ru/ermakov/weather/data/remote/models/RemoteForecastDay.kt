package ru.ermakov.weather.data.remote.models

import com.google.gson.annotations.SerializedName

data class RemoteForecastDay(
    @SerializedName("date")
    val date: String,
    @SerializedName("date_epoch")
    val epochSeconds: Long,
    @SerializedName("day")
    val remoteDay: RemoteDay
)