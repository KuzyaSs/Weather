package ru.ermakov.weather.presentation.screens.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.ermakov.weather.domain.location.LocationProvider
import ru.ermakov.weather.domain.models.Result
import ru.ermakov.weather.domain.repository.WeatherRepository

class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
    private val locationProvider: LocationProvider
) : ViewModel() {
    private val _state = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState> = _state.asStateFlow()

    init {
        getForecast()
    }

    fun getForecast() {
        _state.value = _state.value.copy(isLoading = true, isError = false, error = null)
        viewModelScope.launch {
            when (val locationResult = locationProvider.getCurrentLocation()) {
                is Result.Success -> {
                    val forecastResult = weatherRepository.getForecast(
                        location = locationResult.data
                    )
                    when (forecastResult) {
                        is Result.Success -> {
                            _state.value = _state.value.copy(
                                forecast = forecastResult.data,
                                isLoading = false
                            )
                        }

                        is Result.Error -> {
                            _state.value = _state.value.copy(
                                isLoading = false,
                                isError = true,
                                error = forecastResult.error
                            )
                        }
                    }

                }

                is Result.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        isError = true,
                        error = locationResult.error
                    )
                }
            }
        }
    }
}