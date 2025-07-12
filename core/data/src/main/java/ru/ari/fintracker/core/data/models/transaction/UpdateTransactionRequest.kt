package ru.ari.fintracker.core.data.models.transaction

import ru.ari.fintracker.core.common.utils.format.toUtcIsoString
import java.time.LocalDateTime

data class UpdateTransactionRequest(
    val accountId: Long?,
    val categoryId: Long?,
    val amount: String?,
    val transactionDate: String?,
    val comment: String?
) {
    companion object {
        fun create(
            accountId: Long?,
            categoryId: Long?,
            amount: String?,
            date: LocalDateTime?,
            comment: String?,
        ) = UpdateTransactionRequest(
            accountId = accountId,
            categoryId = categoryId,
            amount = amount,
            transactionDate = date?.toUtcIsoString(),
            comment = comment,
        )
    }
}