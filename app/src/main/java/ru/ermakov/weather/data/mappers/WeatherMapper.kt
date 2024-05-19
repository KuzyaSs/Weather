package ru.ermakov.weather.data.mappers

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.ermakov.weather.data.remote.models.RemoteCurrentForecast
import ru.ermakov.weather.data.remote.models.RemoteForecastDay
import ru.ermakov.weather.domain.models.Day

fun RemoteCurrentForecast.toDay(): Day {
    return Day(
        dayOfWeek = Instant
            .fromEpochSeconds(epochSeconds)
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .dayOfWeek,
        temperature = temperature
    )
}

fun RemoteForecastDay.toDay(): Day {
    return Day(
        dayOfWeek = Instant
            .fromEpochSeconds(epochSeconds)
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .dayOfWeek,
        temperature = remoteDay.averageTemperature
    )
}