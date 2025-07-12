package ru.ari.fintracker.feature.history.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.fintracker.core.domain.models.transaction.TransactionType
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.core.ui.components.utils.rememberDaggerViewModel
import ru.ari.fintracker.feature.history.R
import ru.ari.fintracker.feature.history.di.DaggerHistoryComponent
import ru.ari.fintracker.feature.history.ui.presentation.components.HistoryScreen
import ru.ari.fintracker.feature.history.ui.viewmodel.HistoryViewModel

/**
 * Обертка для экрана истории транзакций (доходов/расходов)
 * @param onLeadingIconClick Обработчик клика по левой иконке в TopBar
 * @param onTrailingIconClick Обработчик клика по правой иконке в TopBar
 * @param isIncomeScreen Флаг, определяющий тип операций:
 *   - `true`: экран истории доходов
 *   - `false`: экран истории расходов (по умолчанию)
 */
@Composable
fun HistoryScreenWrapper(
    onLeadingIconClick: () -> Unit,
    onTrailingIconClick: () -> Unit,
    onItemClick: (Long) -> Unit,
    isIncomeScreen: Boolean = false
) {
    val viewModel: HistoryViewModel = rememberDaggerViewModel(
        createComponent = { coreDeps ->
            DaggerHistoryComponent.factory().create(coreDeps)
        },
        getFactory = { component ->
            component.viewModelFactory()
        }
    )
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    if (isIncomeScreen) {
        viewModel.transactionType = TransactionType.INCOME
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            FinTrackerTopBar(
                title = "Моя история",
                trailingIcon = ImageVector.vectorResource(R.drawable.analysis_icon),
                leadingIcon = ImageVector.vectorResource(R.drawable.back_arrow_icon),
                onTrailingIconClick = onTrailingIconClick,
                onLeadingIconClick = onLeadingIconClick
            )
        }
    ) { innerPadding ->
        HistoryScreen(
            uiState = uiState,
            onAction = viewModel::onAction,
            onItemClick = onItemClick,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding(), bottom = innerPadding.calculateBottomPadding())
        )
    }
}
