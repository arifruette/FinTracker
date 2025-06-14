package ru.ari.feature.settings.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import ru.ari.feature.settings.ui.SettingsScreen
import ru.ari.feature.settings.ui.SettingsViewModel
import ru.ari.ui.navigation.Screen

@Serializable
data object Settings : Screen

fun NavGraphBuilder.settingsScreen() {
    composable<Settings> {
        val viewModel = SettingsViewModel()
        SettingsScreen(viewModel)
    }
}