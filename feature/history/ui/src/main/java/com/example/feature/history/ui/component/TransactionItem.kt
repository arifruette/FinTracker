package com.example.feature.history.ui.component

import ListItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.feature.history.domain.utils.formatMoney
import com.example.feature.history.domain.utils.formatTimeWithLeadingZero
import com.example.feature.history.domain.utils.toCurrencySymbol
import com.example.feature.history.ui.R
import ru.ari.core.domain.model.Transaction

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
        comment = transaction.comment,
        trailingText = formatMoney(
            transaction.amount,
            transaction.account.currency.toCurrencySymbol()
        ),
        trailingSecondaryText = formatTimeWithLeadingZero(transaction.date),
        onItemClick = onClick
    )
}