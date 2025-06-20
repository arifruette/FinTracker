package ru.ari.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.ui.component.IncomeScreen
import ru.ari.ui.components.FinTrackerTopBar
import ru.ari.ui.navigation.MainFlowScreen

@Composable
fun IncomeScreenWrapper(
    route: MainFlowScreen,
    onTopBarIconClick: () -> Unit,
    onFloatingButtonClick: () -> Unit,
    viewModel: IncomeViewModel = IncomeViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            FinTrackerTopBar(route, onTopBarIconClick)
        },
        floatingActionButton = {
            route.FloatingButton(onFloatingButtonClick)
        }
    ) { innerPadding ->
        IncomeScreen(
            uiState = uiState, modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}