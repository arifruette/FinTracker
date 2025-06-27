package ru.ari.fintracker.feature.settings.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.core.ui.navigation.MainFlowScreen
import ru.ari.fintracker.feature.settings.ui.presentation.components.SettingsScreen
import ru.ari.fintracker.feature.settings.ui.viewmodel.SettingsViewModel

@Composable
fun SettingsScreenWrapper(
    route: MainFlowScreen,
    viewModel: SettingsViewModel = SettingsViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            FinTrackerTopBar(route = route, onTrailingIconClick = {})
        }
    ) { innerPadding ->
        SettingsScreen(
            uiState = uiState, modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
