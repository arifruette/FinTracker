package ru.ari.feature.expenses.domain.usecase

import com.example.core.common.utils.Result
import com.example.core.common.utils.map
import com.example.core.common.utils.toCurrencySymbol
import ru.ari.core.domain.models.Transaction
import ru.ari.core.domain.repository.TransactionRepository
import ru.ari.feature.expenses.domain.models.ExpenseData
import java.time.LocalDate
import javax.inject.Inject

class GetExpensesUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
){
    suspend operator fun invoke(
        accountId: Long
    ): Result<ExpenseData> {
        return transactionRepository.getTransactions(
            startDate = LocalDate.now(),
            endDate = LocalDate.now(),
            accountId = accountId
        ).map { transactions ->
            val filtered = transactions.filter { !it.category.isIncome }

            val sorted: List<Transaction> = filtered.sortedByDescending { it.date }

            val amount = calculateAmount(filtered)

            val currency = filtered.firstOrNull()?.account?.currency?.toCurrencySymbol() ?: ""

            ExpenseData(
                expenses = sorted,
                amount = amount,
                currency = currency
            )
        }
    }

    private fun calculateAmount(
        transactions: List<Transaction>
    ): Double = transactions.sumOf { it.amount }
}
