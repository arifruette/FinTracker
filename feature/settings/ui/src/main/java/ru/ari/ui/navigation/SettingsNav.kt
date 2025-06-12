package ru.ari.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import ru.ari.ui.SettingsScreen

@Serializable
data object Settings : Screen

fun NavGraphBuilder.settingsScreen() {
    composable<Settings> {
        SettingsScreen()
    }
}