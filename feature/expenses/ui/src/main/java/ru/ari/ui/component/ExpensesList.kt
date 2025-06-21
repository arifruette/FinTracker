package ru.ari.ui.component

import ListItem
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.core.common.utils.formatMoney
import ru.ari.core.domain.model.Transaction
import ru.ari.feature.expenses.ui.R
import ru.ari.ui.components.EmptyState

@Composable
fun ExpensesList(
    expenses: List<Transaction>,
    modifier: Modifier = Modifier,
) {
    if (expenses.isEmpty()) {
        EmptyState(modifier = modifier.fillMaxSize())
    } else {
        LazyColumn(
            modifier = modifier
        ) {
            items(
                expenses,
                key = { it.id }
            ) { expense ->
                ListItem(
                    content = expense.category.name,
                    leadEmoji = expense.category.emoji,
                    trailingText = formatMoney(expense.amount, expense.account.currency),
                    trailingIcon = ImageVector.vectorResource(R.drawable.arrow_forward_icon),
                    comment = if (expense.comment.isNullOrBlank()) null else expense.comment,
                    onItemClick = {},
                    modifier = Modifier.height(70.dp)
                )
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
            }
        }
    }
}