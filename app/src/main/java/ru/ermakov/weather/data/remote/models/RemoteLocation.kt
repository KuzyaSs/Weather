package ru.ermakov.weather.data.remote.models

import com.google.gson.annotations.SerializedName

data class RemoteLocation(
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("country")
    val country: String
)