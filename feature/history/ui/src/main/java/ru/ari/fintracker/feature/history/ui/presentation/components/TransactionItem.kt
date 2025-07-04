package ru.ari.fintracker.feature.history.ui.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.feature.history.ui.R
import ru.ari.fintracker.core.common.utils.format.formatMoney
import ru.ari.fintracker.core.common.utils.format.formatTimeWithLeadingZero
import ru.ari.fintracker.core.domain.models.Transaction
import ru.ari.fintracker.core.ui.components.ListItem

/**
 * Компонент для отображения транзакции
 */
@Composable
fun TransactionItem(
    transaction: Transaction,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ListItem(
        modifier = modifier,
        content = transaction.category.name,
        leadEmoji = transaction.category.emoji,
        trailingIcon = ImageVector.vectorResource(R.drawable.arrow_forward_icon),
        comment = if (transaction.comment.isNullOrEmpty()) null else transaction.comment,
        trailingText = formatMoney(
            transaction.amount,
            transaction.account.currency.symbol
        ),
        trailingSecondaryText = formatTimeWithLeadingZero(transaction.date),
        onItemClick = onClick
    )
}
