package ru.ari.fintracker.feature.edit_balance.ui.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.ari.fintracker.core.domain.models.Currency
import ru.ari.fintracker.core.ui.components.ListItem
import ru.ari.fintracker.feature.edit_balance.ui.presentation.utils.toLongName

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinTrackerBottomSheet(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onCurrencyClicked: (Currency) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState(),
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = modifier
    ) {
        Column(modifier = Modifier) {
            Text(
                "Выберите валюту",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 24.dp, bottom = 16.dp)
            )

            Currency.entries.forEach { currency ->
                ListItem(
                    content = currency.toLongName(),
                    leadEmoji = currency.symbol,
                    onItemClick = {
                        onCurrencyClicked(currency)
                        onDismiss()
                    },
                    emojiBackgroundColor = Color.Transparent,
                    modifier = Modifier.fillMaxWidth().height(72.dp)
                )
                HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}