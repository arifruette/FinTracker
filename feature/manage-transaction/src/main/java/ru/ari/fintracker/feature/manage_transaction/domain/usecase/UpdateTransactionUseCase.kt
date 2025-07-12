package ru.ari.fintracker.feature.manage_transaction.domain.usecase

import ru.ari.fintracker.core.domain.repository.TransactionRepository
import java.time.LocalDateTime
import javax.inject.Inject

class UpdateTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    @Suppress("LongParameterList")
    suspend operator fun invoke(
        transactionId: Long,
        accountId: Long,
        categoryId: Long,
        amount: String,
        transactionDate: LocalDateTime,
        comment: String
    ) = transactionRepository.updateTransaction(
        transactionId = transactionId,
        accountId = accountId,
        categoryId = categoryId,
        amount = amount,
        transactionDate = transactionDate,
        comment = comment
    )
}