package ru.ari.fintracker.feature.manage_transaction.domain.usecase

import ru.ari.fintracker.core.domain.repository.TransactionRepository
import javax.inject.Inject

class DeleteTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    suspend operator fun invoke(transactionId: Long) = transactionRepository.deleteTransaction(transactionId)
}