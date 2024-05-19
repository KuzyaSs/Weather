package ru.ermakov.weather.data.remote.dataSource

import ru.ermakov.weather.data.mappers.toDay
import ru.ermakov.weather.data.remote.api.WeatherApi
import ru.ermakov.weather.domain.models.Error
import ru.ermakov.weather.domain.models.Forecast
import ru.ermakov.weather.domain.models.Location
import ru.ermakov.weather.domain.models.Result

class WeatherRemoteDataSourceImpl(private val weatherApi: WeatherApi) : WeatherRemoteDataSource {
    override suspend fun getForecast(location: Location): Result<Forecast, Error> {
        val forecastResponse = weatherApi.getForecast(
            location = "${location.latitude},${location.longitude}"
        )
        if (forecastResponse.isSuccessful) {
            forecastResponse.body()?.let { forecast ->
                return Result.Success(
                    data = Forecast(
                        location = forecast.remoteLocation.name,
                        currentForecast = forecast.remoteCurrentForecast.toDay(),
                        days = forecast.remoteForecast.remoteForecastDays.map { remoteForecastDay ->
                            remoteForecastDay.toDay()
                        }
                    )
                )
            }
        }
        return Result.Error(error = Error.CONNECTION_FAILURE)
    }
}