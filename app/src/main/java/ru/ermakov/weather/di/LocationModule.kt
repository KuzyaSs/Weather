package ru.ermakov.weather.di

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import ru.ermakov.weather.data.location.LocationProviderImpl
import ru.ermakov.weather.domain.location.LocationProvider

val locationModule = module {
    single<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(androidApplication())
    }

    single<LocationProvider> {
        LocationProviderImpl(application = androidApplication(), fusedLocationClient = get())
    }
}