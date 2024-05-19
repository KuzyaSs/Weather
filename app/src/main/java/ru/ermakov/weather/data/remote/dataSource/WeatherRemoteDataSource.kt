package ru.ermakov.weather.data.remote.dataSource

import ru.ermakov.weather.domain.models.Error
import ru.ermakov.weather.domain.models.Forecast
import ru.ermakov.weather.domain.models.Location
import ru.ermakov.weather.domain.models.Result

interface WeatherRemoteDataSource {
    suspend fun getForecast(location: Location): Result<Forecast, Error>
}