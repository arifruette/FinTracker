package ru.ari.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.ui.viewmodel.CategoriesViewModel
import ru.ari.ui.components.FinTrackerTopBar
import ru.ari.ui.navigation.MainFlowScreen
import ru.ari.ui.presentation.components.CategoriesScreen

@Composable
fun CategoriesScreenWrapper(
    route: MainFlowScreen,
    viewModel: CategoriesViewModel = CategoriesViewModel()
) {
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
