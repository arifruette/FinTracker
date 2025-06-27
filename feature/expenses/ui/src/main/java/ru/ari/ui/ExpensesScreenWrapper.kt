package ru.ari.ui

import ExpensesScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.ui.components.FinTrackerTopBar
import ru.ari.ui.navigation.MainFlowScreen

@Composable
fun ExpensesScreenWrapper(
    route: MainFlowScreen,
    onTopBarIconClick: () -> Unit,
    onFloatingButtonClick: () -> Unit,
    viewModel: ExpensesViewModel = hiltViewModel()
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
        ExpensesScreen(
            uiState = uiState, modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
