package ru.ari.ui

import ListItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ari.feature.balance.ui.R
import ru.ari.ui.components.ErrorText
import ru.ari.ui.components.Loading

@Composable
fun BalanceScreen(
    viewModel: BalanceViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState = viewModel.state.collectAsStateWithLifecycle()
    when (uiState.value) {
        is BalanceState.Error -> {
            ErrorText(
                errorMessage = (uiState.value as BalanceState.Error).message,
                modifier = modifier.fillMaxSize()
            )
        }

        BalanceState.Loading -> {
            Loading(modifier = modifier.fillMaxSize())
        }

        is BalanceState.Success -> {
            Column(
                modifier = modifier
            ) {
                ListItem(
                    content = "Баланс",
                    trailingText = (uiState.value as BalanceState.Success).balance.totalBalance,
                    trailingIcon = ImageVector.vectorResource(R.drawable.forward_arrow_icon),
                    emojiBackgroundColor = Color.White,
                    lead = (uiState.value as BalanceState.Success).balance.icon,
                    isHighlighted = true,
                    modifier = Modifier.height(56.dp)
                )
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                ListItem(
                    content = "Валюта",
                    trailingText = (uiState.value as BalanceState.Success).balance.currency,
                    trailingIcon = ImageVector.vectorResource(R.drawable.forward_arrow_icon),
                    isHighlighted = true,
                    modifier = Modifier.height(56.dp)
                )
            }
        }
    }
}