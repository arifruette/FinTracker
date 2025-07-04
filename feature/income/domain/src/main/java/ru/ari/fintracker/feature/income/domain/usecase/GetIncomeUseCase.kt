package ru.ari.fintracker.feature.income.domain.usecase


import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.common.utils.map
import ru.ari.fintracker.core.domain.models.Currency
import ru.ari.fintracker.core.domain.models.Transaction
import ru.ari.fintracker.core.domain.repository.TransactionRepository
import ru.ari.fintracker.feature.income.domain.models.IncomeData
import java.time.LocalDate
import javax.inject.Inject

/**
 * UseCase получения данных о доходах по счёту за текущий день.
 *
 * @param transactionRepository репозиторий для доступа к транзакциям
 */
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

            val currency = filtered.firstOrNull()?.account?.currency ?: Currency.RUB

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
