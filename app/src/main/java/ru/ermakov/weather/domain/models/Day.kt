package ru.ermakov.weather.domain.models

import kotlinx.datetime.DayOfWeek

data class Day(
    val dayOfWeek: DayOfWeek,
    val temperature: Double
)