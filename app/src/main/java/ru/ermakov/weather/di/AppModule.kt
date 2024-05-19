package ru.ermakov.weather.di

import org.koin.dsl.module

val appModule = module {
    includes(locationModule, remoteModule, viewModelModule, repositoryModule)
}