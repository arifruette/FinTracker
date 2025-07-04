package ru.ari.fintracker.feature.income.ui.presentation


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.feature.income.ui.R
import ru.ari.fintracker.core.ui.components.FinTrackerFloatingButton
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.feature.income.ui.presentation.components.IncomeScreen
import ru.ari.fintracker.feature.income.ui.viewmodel.IncomeViewModel

/**
 * Composable обертка для экрана доходов, реализующая базовую структуру экрана
 *
 * @param route текущий экран в потоке MainFlowScreen (для кастомизации элементов)
 * @param onTopBarIconClick обработчик клика по иконке в топбаре
 * @param onFloatingButtonClick обработчик клика по плавающей кнопке
 */
@Composable
fun IncomeScreenWrapper(
    onTopBarIconClick: () -> Unit,
    onFloatingButtonClick: () -> Unit
) {
    val viewModel: IncomeViewModel = hiltViewModel()
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            FinTrackerTopBar(
                title = "Доходы сегодня",
                trailingIcon = ImageVector.vectorResource(R.drawable.history_icon),
                onTrailingIconClick = onTopBarIconClick
            )
        },
        floatingActionButton = {
            FinTrackerFloatingButton(onFloatingButtonClick)
        }
    ) { innerPadding ->
        IncomeScreen(
            uiState = uiState, modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
