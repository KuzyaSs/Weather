package ru.ermakov.weather.di

import org.koin.dsl.module
import ru.ermakov.weather.data.repository.WeatherRepositoryImpl
import ru.ermakov.weather.domain.repository.WeatherRepository

val repositoryModule = module {
    single<WeatherRepository> {
        WeatherRepositoryImpl(get())
    }
}