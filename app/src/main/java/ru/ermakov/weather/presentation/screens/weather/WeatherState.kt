package ru.ermakov.weather.presentation.screens.weather

import ru.ermakov.weather.domain.models.Forecast
import ru.ermakov.weather.domain.models.RootError

data class WeatherState(
    val forecast: Forecast? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: RootError? = null
)
