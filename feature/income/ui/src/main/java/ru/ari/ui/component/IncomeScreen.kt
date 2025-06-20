package ru.ari.ui.component

import ListItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.ari.ui.IncomeState
import ru.ari.ui.components.ErrorText
import ru.ari.ui.components.Loading

@Composable
fun IncomeScreen(
    uiState: IncomeState,
    modifier: Modifier = Modifier,
) {
    when (uiState) {
        IncomeState.Loading -> {
            Loading(modifier = modifier.fillMaxSize())
        }
        is IncomeState.Success -> {
            Column(modifier = modifier) {
                ListItem(
                    content = "Всего",
                    trailingText = uiState
                        .totalAmount,
                    isHighlighted = true,
                    modifier = Modifier
                        .height(56.dp)
                )
                IncomeList(incomes = uiState.incomes)
            }
        }

        is IncomeState.Error -> {
            ErrorText(
                errorMessage = uiState.message,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}