package ru.ermakov.weather.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.tasks.await
import ru.ermakov.weather.domain.location.LocationProvider
import ru.ermakov.weather.domain.models.Error
import ru.ermakov.weather.domain.models.Location
import ru.ermakov.weather.domain.models.Result
import ru.ermakov.weather.domain.models.RootError

class LocationProviderImpl(
    private val fusedLocationClient: FusedLocationProviderClient,
    private val application: Application
) : LocationProvider {
    override suspend fun getCurrentLocation(): Result<Location, RootError> {
        // Permission check.
        if (ActivityCompat.checkSelfPermission(
                application,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                application,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return Result.Error(error = Error.LOCATION_PERMISSION_NOT_GRANTED)
        }

        // GPS availability check.
        val locationManager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return Result.Error(error = Error.GPS_NOT_AVAILABLE)
        }

        val location = fusedLocationClient.lastLocation.await()
        return if (location != null) {
            Result.Success(
                data = Location(
                    latitude = location.latitude,
                    longitude = location.longitude
                )
            )
        } else {
            Result.Error(error = Error.LOCATION_ERROR)
        }
    }
}