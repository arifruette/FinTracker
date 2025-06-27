package ru.ari.ui.presentation.components

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
import ru.ari.feature.balance.ui.R
import ru.ari.ui.viewmodel.contract.BalanceState
import ru.ari.ui.components.ErrorText
import ru.ari.ui.components.Loading

@Composable
fun BalanceScreen(
    uiState: BalanceState,
    modifier: Modifier = Modifier,
) {
    when (uiState) {
        is BalanceState.Error -> {
            ErrorText(
                errorMessage = uiState.message,
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
                    trailingText = uiState.balance.totalBalance,
                    trailingIcon = ImageVector.vectorResource(R.drawable.forward_arrow_icon),
                    emojiBackgroundColor = Color.White,
                    leadEmoji = "\uD83D\uDCB0",
                    isHighlighted = true,
                    onItemClick = {},
                    modifier = Modifier.height(56.dp)
                )
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                ListItem(
                    content = "Валюта",
                    trailingText = uiState.balance.currency,
                    trailingIcon = ImageVector.vectorResource(R.drawable.forward_arrow_icon),
                    isHighlighted = true,
                    onItemClick = {},
                    modifier = Modifier.height(56.dp)
                )
            }
        }
    }
}
