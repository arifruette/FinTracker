package ru.ari.ui.component

import ListItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.ari.ui.ExpensesState
import ru.ari.ui.components.ErrorText
import ru.ari.ui.components.Loading

@Composable
fun ExpensesScreen(
    uiState: ExpensesState,
    modifier: Modifier = Modifier,
) {
    when (uiState) {
        ExpensesState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is ExpensesState.Success -> {
            Column(modifier = modifier.fillMaxSize()) {
                ListItem(
                    content = "Всего",
                    trailingText = uiState
                        .totalAmount,
                    isHighlighted = true,
                    modifier = Modifier
                        .height(56.dp)
                )
                ExpensesList(
                    expenses = uiState.expenses
                )
            }
        }

        is ExpensesState.Error -> {
            ErrorText(
                errorMessage = uiState.message,
                modifier = modifier.fillMaxSize()
            )
        }
    }
}
