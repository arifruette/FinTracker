package com.example.feature.history.ui.presentation

import HistoryScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.feature.history.ui.viewmodel.HistoryViewModel
import ru.ari.core.domain.models.TransactionType
import ru.ari.ui.components.FinTrackerTopBar
import ru.ari.ui.navigation.Screen

@Composable
fun HistoryScreenWrapper(
    route: Screen,
    onLeadingIconClick: () -> Unit,
    onTrailingIconClick: () -> Unit,
    isIncomeScreen: Boolean = false,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    if (isIncomeScreen) {
        viewModel.transactionType = TransactionType.INCOME
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            FinTrackerTopBar(
                route = route,
                onTrailingIconClick = onTrailingIconClick,
                onLeadingIconClick = onLeadingIconClick
            )
        }
    ) { innerPadding ->
        HistoryScreen(
            uiState = uiState,
            onAction = viewModel::onAction,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding(), bottom = innerPadding.calculateBottomPadding())
        )
    }
}
