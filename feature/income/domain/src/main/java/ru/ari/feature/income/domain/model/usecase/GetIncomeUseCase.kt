package ru.ari.feature.income.domain.model.usecase

import com.example.core.common.utils.Result
import com.example.core.common.utils.map
import com.example.core.common.utils.toCurrencySymbol
import ru.ari.core.domain.model.Transaction
import ru.ari.core.domain.repository.TransactionRepository
import ru.ari.feature.income.domain.model.IncomeData
import java.time.LocalDate
import javax.inject.Inject

class GetIncomeUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
){
    suspend operator fun invoke(
        accountId: Long
    ): Result<IncomeData> {
        return transactionRepository.getTransactions(
            startDate = LocalDate.now(),
            endDate = LocalDate.now(),
            accountId = accountId
        ).map { transactions ->
            val filtered = transactions.filter { it.category.isIncome }

            val sorted: List<Transaction> = filtered.sortedByDescending { it.date }

            val amount = calculateAmount(filtered)

            val currency = filtered.firstOrNull()?.account?.currency?.toCurrencySymbol() ?: ""

            IncomeData(
                income = sorted,
                amount = amount,
                currency = currency
            )
        }
    }

    private fun calculateAmount(
        transactions: List<Transaction>
    ): Double = transactions.sumOf { it.amount }
}
