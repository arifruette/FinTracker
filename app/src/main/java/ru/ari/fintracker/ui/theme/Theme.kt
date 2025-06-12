package ru.ari.fintracker.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = SpringGreen,
    secondary = LightGreen,
    tertiary = Magnolia,
    surface = Magnolia,
    onSurface = RaisinBlack,
    onSurfaceVariant = DarkGray,
    primaryContainer = DarkMagnolia,
    secondaryContainer = LightGreen,
    onSecondaryContainer = SpringGreen
)

@Composable
fun FinTrackerTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}