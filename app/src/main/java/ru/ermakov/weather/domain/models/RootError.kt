package ru.ermakov.weather.domain.models

interface RootError

enum class Error : RootError {
    LOCATION_PERMISSION_NOT_GRANTED,
    GPS_NOT_AVAILABLE,
    LOCATION_ERROR,
    CONNECTION_FAILURE
}