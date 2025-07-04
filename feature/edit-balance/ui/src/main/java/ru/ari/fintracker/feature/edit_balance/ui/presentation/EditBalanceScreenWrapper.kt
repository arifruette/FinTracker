package ru.ari.fintracker.feature.edit_balance.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.core.ui.navigation.Screen
import ru.ari.fintracker.feature.edit_balance.ui.presentation.components.EditBalanceScreen
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.EditBalanceViewModel
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenAction.UpdateAccountInfo

@Composable
fun EditBalanceScreenWrapper(
    route: Screen,
    onCancelButtonClick: () -> Unit,
) {
    val viewModel: EditBalanceViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    Scaffold(
        topBar = {
            FinTrackerTopBar(
                route = route,
                onTrailingIconClick = {
                    (viewModel::onAction)(UpdateAccountInfo(onSuccess = { onCancelButtonClick() }))
                },
                onLeadingIconClick = onCancelButtonClick
            )
        }
    ) { innerPadding ->
        EditBalanceScreen(
            uiState = uiState,
            uiEffect = uiEffect,
            onAction = viewModel::onAction,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
        )
    }
}