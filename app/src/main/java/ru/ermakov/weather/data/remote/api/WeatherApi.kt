package ru.ermakov.weather.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.ermakov.weather.BuildConfig
import ru.ermakov.weather.data.remote.models.RemoteWeather

private const val DEFAULT_DAYS = 10
private const val DEFAULT_LANGUAGE = "ru"

interface WeatherApi {
    @GET("forecast.json")
    suspend fun getForecast(
        @Query("q") location: String,
        @Query("key") apiKey: String = BuildConfig.API_KEY,
        @Query("days") days: Int = DEFAULT_DAYS,
        @Query("lang") language: String = DEFAULT_LANGUAGE
    ): Response<RemoteWeather>
}