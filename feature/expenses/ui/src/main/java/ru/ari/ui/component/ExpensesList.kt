package ru.ari.ui.component

import ListItem
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
import ru.ari.feature.expenses.domain.Expense
import ru.ari.feature.expenses.ui.R

@Composable
fun ExpensesList(
    expenses: List<Expense>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            expenses,
            key = { it.id }
        ) { expense ->
            ListItem(
                content = expense.content,
                leadEmoji = expense.icon,
                trailingText = expense.amount,
                trailingIcon = ImageVector.vectorResource(R.drawable.arrow_forward_icon),
                comment = expense.comment,
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