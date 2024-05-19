package ru.ermakov.weather.data.remote.models

import com.google.gson.annotations.SerializedName

data class RemoteDay(
    @SerializedName("avgtemp_c")
    val averageTemperature: Double
)