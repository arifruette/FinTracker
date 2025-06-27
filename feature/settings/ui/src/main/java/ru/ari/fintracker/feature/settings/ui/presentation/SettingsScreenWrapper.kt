package ru.ari.fintracker.feature.settings.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.core.ui.navigation.MainFlowScreen
import ru.ari.fintracker.feature.settings.ui.presentation.components.SettingsScreen

@Composable
fun SettingsScreenWrapper(
    route: MainFlowScreen
) {
    Scaffold(
        topBar = {
            FinTrackerTopBar(route = route, onTrailingIconClick = {})
        }
    ) { innerPadding ->
        SettingsScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
