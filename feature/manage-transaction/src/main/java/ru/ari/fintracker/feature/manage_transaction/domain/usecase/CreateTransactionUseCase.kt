package ru.ari.fintracker.feature.manage_transaction.domain.usecase

import ru.ari.fintracker.core.domain.repository.TransactionRepository
import java.time.LocalDateTime
import javax.inject.Inject

class CreateTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    suspend operator fun invoke(
        accountId: Long,
        categoryId: Long,
        amount: String,
        transactionDate: LocalDateTime,
        comment: String
    ) = transactionRepository.createTransaction(
        accountId = accountId,
        categoryId = categoryId,
        amount = amount,
        transactionDate = transactionDate,
        comment = comment
    )
}