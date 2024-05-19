package ru.ermakov.weather.presentation

import android.content.Context
import kotlinx.datetime.DayOfWeek
import ru.ermakov.weather.R
import ru.ermakov.weather.domain.models.Error
import ru.ermakov.weather.domain.models.RootError

fun DayOfWeek.toStringDay(context: Context, isToday: Boolean): String {
    return if (isToday) {
        context.getString(R.string.today)
    } else {
        when (this) {
            java.time.DayOfWeek.MONDAY -> context.getString(R.string.monday)
            java.time.DayOfWeek.TUESDAY -> context.getString(R.string.tuesday)
            java.time.DayOfWeek.WEDNESDAY -> context.getString(R.string.wednesday)
            java.time.DayOfWeek.THURSDAY -> context.getString(R.string.thursday)
            java.time.DayOfWeek.FRIDAY -> context.getString(R.string.friday)
            java.time.DayOfWeek.SATURDAY -> context.getString(R.string.saturday)
            java.time.DayOfWeek.SUNDAY -> context.getString(R.string.sunday)
        }
    }
}

fun RootError.toStringError(context: Context): String {
    return if (this is Error) {
        when (this) {
            Error.LOCATION_PERMISSION_NOT_GRANTED -> context.getString(R.string.location_permission_not_granted_error)
            Error.GPS_NOT_AVAILABLE -> context.getString(R.string.gps_not_available_error)
            Error.LOCATION_ERROR -> context.getString(R.string.location_receiving_error)
            Error.CONNECTION_FAILURE -> context.getString(R.string.connection_failure_error)
        }
    } else {
        throw NotImplementedError()
    }
}