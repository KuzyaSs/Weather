package ru.ermakov.weather.presentation.screens.weather

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import ru.ermakov.weather.presentation.screens.weather.components.ErrorWeatherScreen
import ru.ermakov.weather.presentation.screens.weather.components.LoadingWeatherScreen
import ru.ermakov.weather.presentation.screens.weather.components.SuccessfulWeatherScreen
import ru.ermakov.weather.presentation.theme.WeatherTheme
import ru.ermakov.weather.presentation.toStringError

@Composable
fun WeatherScreen(
    state: WeatherState,
    onRetryButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    when {
        state.isLoading -> {
            LoadingWeatherScreen(modifier = modifier)
        }

        state.isError && state.error != null -> {
            ErrorWeatherScreen(
                errorMessage = state.error.toStringError(context = LocalContext.current),
                onRetryButtonClick = onRetryButtonClick,
                modifier = modifier
            )
        }

        state.forecast != null -> {
            SuccessfulWeatherScreen(forecast = state.forecast, modifier = modifier)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeatherScreenPreview() {
    WeatherTheme {
        Surface {
            WeatherScreen(state = WeatherState(isLoading = true), onRetryButtonClick = {})
        }
    }
}