package ru.ermakov.weather.domain.location

import ru.ermakov.weather.domain.models.Location
import ru.ermakov.weather.domain.models.Result
import ru.ermakov.weather.domain.models.RootError

interface LocationProvider {
    suspend fun getCurrentLocation(): Result<Location, RootError>
}