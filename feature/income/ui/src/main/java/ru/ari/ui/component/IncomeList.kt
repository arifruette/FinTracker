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
import ru.ari.ui.components.EmptyState

@Composable
fun IncomeList(
    income: List<Transaction>,
    modifier: Modifier = Modifier,
) {
    if (income.isEmpty()) {
        EmptyState(modifier = modifier.fillMaxSize())
    } else {
        LazyColumn(
            modifier = modifier
        ) {
            items(
                income,
                key = { it.id }
            ) { income ->
                ListItem(
                    content = income.category.name,
                    leadEmoji = income.category.emoji,
                    trailingText = formatMoney(income.amount, income.account.currency),
                    trailingIcon = ImageVector.vectorResource(ru.ari.feature.income.ui.R.drawable.arrow_forward_icon),
                    comment = if (income.comment.isNullOrBlank()) null else income.comment,
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
