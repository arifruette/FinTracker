package ru.ari.fintracker.feature.expenses.ui.presentation


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.core.ui.navigation.MainFlowScreen
import ru.ari.fintracker.feature.expenses.ui.presentation.components.ExpensesScreen
import ru.ari.fintracker.feature.expenses.ui.viewmodel.ExpensesViewModel

/**
 * Обертка для экрана расходов, интегрирующая UI с ViewModel и Scaffold
 * @param route Текущий экран для конфигурации TopBar и FAB
 * @param onTopBarIconClick Обработчик клика по иконке в верхней панели
 * @param onFloatingButtonClick Обработчик клика по плавающей кнопке
 */
@Composable
fun ExpensesScreenWrapper(
    route: MainFlowScreen,
    onTopBarIconClick: () -> Unit,
    onFloatingButtonClick: () -> Unit
) {
    val viewModel: ExpensesViewModel = hiltViewModel()
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
