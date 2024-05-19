package ru.ermakov.weather.domain.repository

import ru.ermakov.weather.domain.models.Error
import ru.ermakov.weather.domain.models.Forecast
import ru.ermakov.weather.domain.models.Location
import ru.ermakov.weather.domain.models.Result

interface WeatherRepository {
    suspend fun getForecast(location: Location): Result<Forecast, Error>
}