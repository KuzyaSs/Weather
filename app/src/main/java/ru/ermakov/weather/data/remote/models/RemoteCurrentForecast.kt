package ru.ermakov.weather.data.remote.models

import com.google.gson.annotations.SerializedName

data class RemoteCurrentForecast(
    @SerializedName("temp_c")
    val temperature: Double,
    @SerializedName("last_updated_epoch")
    val epochSeconds: Long
)