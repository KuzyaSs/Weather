package ru.ermakov.weather.domain.models

data class Forecast(
    val location: String,
    val currentForecast: Day,
    val days: List<Day>
)