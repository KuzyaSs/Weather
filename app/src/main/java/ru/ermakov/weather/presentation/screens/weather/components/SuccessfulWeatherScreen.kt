package ru.ermakov.weather.presentation.screens.weather.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.DayOfWeek
import ru.ermakov.weather.R
import ru.ermakov.weather.domain.models.Day
import ru.ermakov.weather.domain.models.Forecast
import ru.ermakov.weather.presentation.theme.WeatherTheme

@Composable
fun SuccessfulWeatherScreen(forecast: Forecast, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = forecast.location,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(
                id = R.string.temperature,
                forecast.currentForecast.temperature.toString()
            ),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 48.dp)
        )
        ForecastDayList(days = forecast.days)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SuccessfulWeatherScreenPreview() {
    WeatherTheme {
        Surface {
            SuccessfulWeatherScreen(
                Forecast(
                    location = "Some location",
                    currentForecast = Day(dayOfWeek = DayOfWeek.FRIDAY, temperature = 20.0),
                    days = listOf(Day(dayOfWeek = DayOfWeek.FRIDAY, temperature = 20.0))
                )
            )
        }
    }
}