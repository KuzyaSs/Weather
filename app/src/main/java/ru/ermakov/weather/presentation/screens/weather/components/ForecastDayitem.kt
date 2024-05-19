package ru.ermakov.weather.presentation.screens.weather.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.DayOfWeek
import ru.ermakov.weather.R
import ru.ermakov.weather.domain.models.Day
import ru.ermakov.weather.presentation.theme.WeatherTheme
import ru.ermakov.weather.presentation.toStringDay

@Composable
fun ForecastDayItem(day: Day, isToday: Boolean, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = day.dayOfWeek.toStringDay(context = LocalContext.current, isToday = isToday),
            fontSize = 24.sp,
            modifier = Modifier.weight(0.7f)
        )
        Text(
            text = stringResource(id = R.string.temperature, day.temperature.toString()),
            fontSize = 24.sp,
            modifier = Modifier.weight(0.3f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ForecastDayItemPreview() {
    WeatherTheme {
        Surface {
            ForecastDayItem(
                day = Day(dayOfWeek = DayOfWeek.FRIDAY, temperature = 20.0),
                isToday = false
            )
        }
    }
}