package ru.ari.fintracker.feature.settings.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.feature.settings.ui.presentation.components.SettingsScreen

@Composable
fun SettingsScreenWrapper() {
    Scaffold(
        topBar = {
            FinTrackerTopBar(title = "Настройки")
        }
    ) { innerPadding ->
        SettingsScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
