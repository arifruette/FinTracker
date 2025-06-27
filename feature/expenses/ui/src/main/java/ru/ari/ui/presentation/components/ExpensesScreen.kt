import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.common.utils.formatMoney
import ru.ari.ui.viewmodel.contract.ExpensesState
import ru.ari.ui.presentation.components.ExpensesList
import ru.ari.ui.components.ErrorText
import ru.ari.ui.components.Loading

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
