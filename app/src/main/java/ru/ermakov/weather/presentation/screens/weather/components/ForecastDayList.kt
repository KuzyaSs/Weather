package ru.ermakov.weather.presentation.screens.weather.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.datetime.DayOfWeek
import ru.ermakov.weather.domain.models.Day
import ru.ermakov.weather.presentation.theme.WeatherTheme

@Composable
fun ForecastDayList(days: List<Day>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(space = 16.dp)) {
        itemsIndexed(days) { index, day ->
            ForecastDayItem(day = day, isToday = index == 0)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForecastDayListPreview() {
    WeatherTheme {
        Surface {
            ForecastDayList(days = listOf(Day(dayOfWeek = DayOfWeek.FRIDAY, temperature = 20.0)))
        }
    }
}