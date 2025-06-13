package ru.ari.ui

import ListItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.ui.component.IncomeList
import ru.ari.ui.components.ErrorText
import ru.ari.ui.components.Loading

@Composable
fun IncomeScreen(
    viewModel: IncomesViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState = viewModel.state.collectAsStateWithLifecycle()
    when (uiState.value) {
        IncomeState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is IncomeState.Success -> {
            Column(modifier = modifier) {
                ListItem(
                    content = "Всего",
                    trailingText = (uiState.value as IncomeState.Success)
                        .totalAmount,
                    isHighlighted = true,
                    modifier = Modifier
                        .height(56.dp)
                )
                IncomeList(incomes = (uiState.value as IncomeState.Success).incomes)
            }
        }

        is IncomeState.Error -> {
            ErrorText(
                errorMessage = (uiState.value as IncomeState.Error).message,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}