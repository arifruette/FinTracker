package com.example.feature.history.domain.usecase

import com.example.core.common.utils.Result
import com.example.core.common.utils.map
import com.example.feature.history.domain.model.HistoryData
import com.example.feature.history.domain.utils.toCurrencySymbol
import ru.ari.core.domain.model.Transaction
import ru.ari.core.domain.model.TransactionType
import ru.ari.core.domain.repository.TransactionRepository
import java.time.LocalDate
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    suspend operator fun invoke(
        startDate: LocalDate,
        endDate: LocalDate,
        accountId: Long,
        transactionType: TransactionType
    ): Result<HistoryData> {
        return transactionRepository.getTransactions(
            startDate = startDate,
            endDate = endDate,
            accountId = accountId
        ).map { transactions ->
            val filtered = when (transactionType) {
                TransactionType.INCOME -> transactions.filter { it.category.isIncome }
                TransactionType.EXPENSE -> transactions.filter { !it.category.isIncome }
            }

            val sorted: List<Transaction> = filtered.sortedByDescending { it.date }

            val amount = calculateAmount(filtered, transactionType)

            val currency = filtered.firstOrNull()?.account?.currency?.toCurrencySymbol() ?: ""

            HistoryData(
                transactions = sorted,
                amount = amount,
                currency = currency
            )
        }
    }

    private fun calculateAmount(
        transactions: List<Transaction>,
        type: TransactionType
    ): Double {
        return when (type) {
            TransactionType.INCOME ->
                transactions.sumOf { it.amount }

            TransactionType.EXPENSE ->
                transactions.sumOf { it.amount }
        }
    }
}