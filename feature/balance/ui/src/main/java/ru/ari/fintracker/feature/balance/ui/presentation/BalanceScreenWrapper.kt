package ru.ari.fintracker.feature.balance.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.core.ui.navigation.MainFlowScreen
import ru.ari.fintracker.feature.balance.ui.presentation.components.BalanceScreen
import ru.ari.fintracker.feature.balance.ui.viewmodel.BalanceViewModel

@Composable
fun BalanceScreenWrapper(
    route: MainFlowScreen,
    onTopBarIconClick: () -> Unit,
    onFloatingButtonClick: () -> Unit,
    viewModel: BalanceViewModel = BalanceViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            FinTrackerTopBar(route = route, onTrailingIconClick = onTopBarIconClick)
        },
        floatingActionButton = {
            route.FloatingButton(onFloatingButtonClick)
        }
    ) { innerPadding ->
        BalanceScreen(
            uiState = uiState, modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
