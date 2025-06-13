package ru.ari.ui

import ListItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.ui.component.ExpensesList
import ru.ari.ui.components.Loading

@Composable
fun ExpensesScreen(
    viewModel: ExpensesViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState = viewModel.state.collectAsStateWithLifecycle()
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        when (uiState.value) {
            ExpensesState.Loading -> Loading(modifier = Modifier.fillMaxSize())
            is ExpensesState.Success -> {
                Column {
                    ListItem(
                        content = "Всего",
                        trailingText = (uiState.value as ExpensesState.Success)
                            .totalAmount.toString(),
                        isHighlighted = true,
                        modifier = Modifier
                            .height(56.dp)
                    )
                    ExpensesList(
                        expenses = (uiState.value as ExpensesState.Success).expenses
                    )
                }
            }
        }
    }
}