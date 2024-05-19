package ru.ermakov.weather

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ermakov.weather.presentation.screens.weather.WeatherScreen
import ru.ermakov.weather.presentation.screens.weather.WeatherViewModel
import ru.ermakov.weather.presentation.theme.WeatherTheme

class WeatherActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { }.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
        setContent {
            WeatherTheme {
                Surface {
                    val state by weatherViewModel.state.collectAsState()
                    WeatherScreen(state = state, onRetryButtonClick = weatherViewModel::getForecast)
                }
            }
        }
    }
}