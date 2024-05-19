package ru.ermakov.weather.data.repository

import ru.ermakov.weather.data.remote.dataSource.WeatherRemoteDataSource
import ru.ermakov.weather.domain.models.Error
import ru.ermakov.weather.domain.models.Forecast
import ru.ermakov.weather.domain.models.Location
import ru.ermakov.weather.domain.models.Result
import ru.ermakov.weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherRemoteDataSource: WeatherRemoteDataSource
) : WeatherRepository {
    override suspend fun getForecast(location: Location): Result<Forecast, Error> {
        return weatherRemoteDataSource.getForecast(location = location)
    }
}