
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.common.utils.formatMoney
import com.example.feature.history.ui.viewmodel.contract.HistoryAction
import com.example.feature.history.ui.viewmodel.contract.HistoryState
import com.example.feature.history.ui.presentation.components.TransactionItem
import ru.ari.ui.components.EmptyState
import ru.ari.ui.components.ErrorText
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
    when {
        uiState.isLoading -> Loading(modifier = modifier)
        uiState.errorMessage != null -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                ErrorText(
                    errorMessage = uiState.errorMessage,
                    modifier = Modifier
                )
            }
        }
        else -> {
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
                if (uiState.transactions.isEmpty()) {
                    EmptyState(modifier = Modifier.fillMaxSize())
                } else {
                    LazyColumn {
                        items(uiState.transactions, key = {it.id}) { transaction ->
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
    }
}
