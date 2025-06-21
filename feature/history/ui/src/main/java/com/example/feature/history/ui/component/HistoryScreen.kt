import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.feature.history.domain.utils.formatMoney
import com.example.feature.history.ui.HistoryAction
import com.example.feature.history.ui.HistoryState
import com.example.feature.history.ui.component.TransactionItem
import ru.ari.ui.components.Loading

@Composable
fun HistoryScreen(
    uiState: HistoryState,
    onAction: (HistoryAction) -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        onAction(HistoryAction.LoadTransactions)
    }

    if (uiState.isLoading) {
        Loading(modifier = modifier)
    } else {
        Column(
            modifier = modifier
        ) {
            DateSelector(
                label = "Начало",
                date = uiState.dateStart,
                modifier = Modifier.height(56.dp),
                onDateSelected = { newDate ->
                    onAction(HistoryAction.UpdateDateStart(newDate))
                }
            )

            HorizontalDivider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )

            DateSelector(
                label = "Конец",
                date = uiState.dateEnd,
                modifier = Modifier.height(56.dp),
                onDateSelected = { newDate ->
                    onAction(HistoryAction.UpdateDateEnd(newDate))
                }
            )

            HorizontalDivider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )

            ListItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                content = "Сумма",
                isHighlighted = true,
                trailingText = formatMoney(uiState.amount, uiState.currency)
            )

            HorizontalDivider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )

            uiState.errorMessage?.let { error ->
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = error,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }

            LazyColumn {
                items(uiState.transactions) { transaction ->
                    TransactionItem(
                        transaction,
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                    )
                    HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
                }
            }
        }
    }
}