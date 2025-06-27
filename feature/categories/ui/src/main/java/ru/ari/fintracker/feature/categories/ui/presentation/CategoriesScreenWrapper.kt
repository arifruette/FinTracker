package ru.ari.fintracker.feature.categories.ui.presentation

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
import ru.ari.fintracker.feature.categories.ui.presentation.components.CategoriesScreen
import ru.ari.fintracker.feature.categories.ui.viewmodel.CategoriesViewModel

/**
 * Обертка для экрана категорий, интегрирующая UI с ViewModel и базовой структурой экрана
 * @param route Текущий экран для конфигурации верхней панели
 */
@Composable
fun CategoriesScreenWrapper(
    route: MainFlowScreen
) {
    val viewModel: CategoriesViewModel = hiltViewModel()
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            FinTrackerTopBar(route = route, onTrailingIconClick = {})
        }
    ) { innerPadding ->
        CategoriesScreen(
            uiState = uiState, modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
