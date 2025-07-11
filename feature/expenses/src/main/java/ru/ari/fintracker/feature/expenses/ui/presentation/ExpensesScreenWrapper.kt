package ru.ari.fintracker.feature.expenses.ui.presentation


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.fintracker.core.ui.components.FinTrackerFloatingButton
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.core.ui.components.utils.rememberDaggerViewModel
import ru.ari.fintracker.feature.expenses.R
import ru.ari.fintracker.feature.expenses.di.DaggerExpensesComponent
import ru.ari.fintracker.feature.expenses.ui.presentation.components.ExpensesScreen
import ru.ari.fintracker.feature.expenses.ui.viewmodel.ExpensesViewModel

/**
 * Обертка для экрана расходов, интегрирующая UI с ViewModel и Scaffold
 * @param onTopBarIconClick Обработчик клика по иконке в верхней панели
 * @param onFloatingButtonClick Обработчик клика по плавающей кнопке
 */
@Composable
fun ExpensesScreenWrapper(
    onTopBarIconClick: () -> Unit,
    onExpenseClick: (Long) -> Unit,
    onFloatingButtonClick: () -> Unit
) {
    val viewModel: ExpensesViewModel = rememberDaggerViewModel(
        createComponent = { coreDeps ->
            DaggerExpensesComponent.factory().create(coreDeps)
        },
        getFactory = { component ->
            component.viewModelFactory()
        }
    )

    val uiState by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            FinTrackerTopBar(
                title = "Расходы сегодня",
                trailingIcon = ImageVector.vectorResource(R.drawable.history_icon),
                onTrailingIconClick = onTopBarIconClick
            )
        },
        floatingActionButton = {
            FinTrackerFloatingButton(onFloatingButtonClick)
        }
    ) { innerPadding ->
        ExpensesScreen(
            uiState = uiState, modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            onExpenseClick = onExpenseClick,
        )
    }
}
