package ru.ermakov.weather.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.ermakov.weather.presentation.screens.weather.WeatherViewModel

val viewModelModule = module {
    viewModel<WeatherViewModel> {
        WeatherViewModel(get(), get())
    }
}