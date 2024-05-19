package ru.ermakov.weather.presentation.screens.weather.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ermakov.weather.R
import ru.ermakov.weather.presentation.theme.WeatherTheme

@Composable
fun ErrorWeatherScreen(
    errorMessage: String,
    onRetryButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = errorMessage,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )
        Button(onClick = { onRetryButtonClick() }) {
            Text(text = stringResource(id = R.string.retry_again))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ErrorWeatherScreenPreview() {
    WeatherTheme {
        Surface {
            ErrorWeatherScreen(errorMessage = "Some error message", onRetryButtonClick = {})
        }
    }
}