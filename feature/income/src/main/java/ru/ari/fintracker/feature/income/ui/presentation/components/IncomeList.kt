package ru.ari.fintracker.feature.income.ui.presentation.components

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
import ru.ari.fintracker.core.common.utils.format.formatMoney
import ru.ari.fintracker.core.domain.models.transaction.Transaction
import ru.ari.fintracker.core.ui.components.EmptyState
import ru.ari.fintracker.core.ui.components.ListItem
import ru.ari.fintracker.feature.income.R


/**
 * Компонент для отображения списка доходов
 * @param income Список доходов
 * @param modifier Модификатор для кастомизации
 */
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
                    trailingText = formatMoney(income.amount, income.account.currency.symbol),
                    trailingIcon = ImageVector.vectorResource(R.drawable.arrow_forward_icon),
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
