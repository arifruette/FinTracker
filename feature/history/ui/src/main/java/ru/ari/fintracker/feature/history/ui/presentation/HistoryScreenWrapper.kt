package ru.ari.fintracker.feature.history.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.fintracker.core.domain.models.TransactionType
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.core.ui.navigation.Screen
import ru.ari.fintracker.feature.history.ui.presentation.components.HistoryScreen
import ru.ari.fintracker.feature.history.ui.viewmodel.HistoryViewModel
/**
 * Обертка для экрана истории транзакций (доходов/расходов)
 * @param route Текущий экран для настройки TopBar
 * @param onLeadingIconClick Обработчик клика по левой иконке в TopBar
 * @param onTrailingIconClick Обработчик клика по правой иконке в TopBar
 * @param isIncomeScreen Флаг, определяющий тип операций:
 *   - `true`: экран истории доходов
 *   - `false`: экран истории расходов (по умолчанию)
 */
@Composable
fun HistoryScreenWrapper(
    route: Screen,
    onLeadingIconClick: () -> Unit,
    onTrailingIconClick: () -> Unit,
    isIncomeScreen: Boolean = false
) {
    val viewModel: HistoryViewModel = hiltViewModel()
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
