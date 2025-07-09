package ru.ari.fintracker.feature.expenses.domain.usecase

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.common.utils.map
import ru.ari.fintracker.core.domain.models.account.Currency
import ru.ari.fintracker.core.domain.models.transaction.Transaction
import ru.ari.fintracker.core.domain.repository.TransactionRepository
import ru.ari.fintracker.feature.expenses.domain.models.ExpenseData
import java.time.LocalDate
import javax.inject.Inject

/**
 * Сценарий получения данных о расходах за текущий день.
 *
 */
class GetExpensesUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
){
    /**
     *  * @param accountId Идентификатор счёта у которого получаем транзакции
     */
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

            val currency = filtered.firstOrNull()?.account?.currency ?: Currency.RUB

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
