package ru.ari.fintracker.feature.history.domain.usecase

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.common.utils.map
import ru.ari.fintracker.core.domain.models.account.Currency
import ru.ari.fintracker.core.domain.models.transaction.Transaction
import ru.ari.fintracker.core.domain.models.transaction.TransactionType
import ru.ari.fintracker.core.domain.repository.TransactionRepository
import ru.ari.fintracker.feature.history.domain.models.HistoryData
import java.time.LocalDate
import javax.inject.Inject

/**
 * Usecase получения истории транзакций с фильтрацией по типу операций
 */
class GetHistoryUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    /**
     * Параметры:
     * @param startDate Начальная дата периода
     * @param endDate Конечная дата периода
     * @param accountId Идентификатор банковского счёта
     * @param transactionType Тип операций для фильтрации:
     *   - `TransactionType.INCOME`: только доходы
     *   - `TransactionType.EXPENSE`: только расходы
     */
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
            val currency = filtered.firstOrNull()?.account?.currency ?: Currency.RUB
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
