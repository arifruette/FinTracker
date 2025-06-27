package ru.ari.fintracker.feature.expenses.ui.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.ari.fintracker.core.common.utils.formatMoney
import ru.ari.fintracker.core.ui.components.ErrorText
import ru.ari.fintracker.core.ui.components.ListItem
import ru.ari.fintracker.core.ui.components.Loading
import ru.ari.fintracker.feature.expenses.ui.viewmodel.contract.ExpensesState

@Composable
fun ExpensesScreen(
    uiState: ExpensesState,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        when {
            uiState.isLoading -> {
                Loading(modifier = Modifier.fillMaxSize())
            }

            uiState.errorMessage != null -> {
                ErrorText(
                    errorMessage = uiState.errorMessage,
                    modifier = Modifier.fillMaxSize()
                )
            }

            else -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    ListItem(
                        content = "Всего",
                        trailingText = formatMoney(uiState.amount, uiState.currency),
                        isHighlighted = true,
                        modifier = Modifier
                            .height(56.dp)
                    )
                    ExpensesList(
                        expenses = uiState.expenses
                    )
                }
            }
        }
    }
}
