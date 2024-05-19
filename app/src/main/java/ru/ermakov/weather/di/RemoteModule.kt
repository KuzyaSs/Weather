package ru.ermakov.weather.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ermakov.weather.data.remote.api.WeatherApi
import ru.ermakov.weather.data.remote.dataSource.WeatherRemoteDataSource
import ru.ermakov.weather.data.remote.dataSource.WeatherRemoteDataSourceImpl

private const val BASE_URL = "https://api.weatherapi.com/v1/"

val remoteModule = module {
    single<Retrofit> {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<WeatherApi> {
        (get() as Retrofit).create(WeatherApi::class.java)
    }

    single<WeatherRemoteDataSource> {
        WeatherRemoteDataSourceImpl(get())
    }
}