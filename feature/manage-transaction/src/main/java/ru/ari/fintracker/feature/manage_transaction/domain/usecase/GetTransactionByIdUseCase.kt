package ru.ari.fintracker.feature.manage_transaction.domain.usecase

import ru.ari.fintracker.core.domain.repository.TransactionRepository
import javax.inject.Inject

class GetTransactionByIdUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    suspend operator fun invoke(transactionId: Long) = transactionRepository.getTransactionById(transactionId)
}