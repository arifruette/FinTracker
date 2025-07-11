package ru.ari.fintracker.core.domain.repository

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.transaction.Transaction
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Репозиторий для управления операциями с транзакциями
 */
interface TransactionRepository {

    /**
     * Получает список транзакций за указанный период для конкретного счёта
     *
     * @param startDate Начальная дата периода (включительно)
     * @param endDate Конечная дата периода (включительно)
     * @param accountId Идентификатор счёта
     *
     * @return [Result] с списком транзакций внутри в случае успеха
     */
    suspend fun getTransactions(
        startDate: LocalDate,
        endDate: LocalDate,
        accountId: Long
    ): Result<List<Transaction>>

    suspend fun createTransaction(
        accountId: Long,
        categoryId: Long,
        amount: String,
        transactionDate: LocalDateTime,
        comment: String,
    ): Result<Transaction?>

    @Suppress("LongParameterList")
    suspend fun updateTransaction(
        transactionId: Long,
        accountId: Long?,
        categoryId: Long?,
        amount: String?,
        transactionDate: LocalDateTime?,
        comment: String?,
    ): Result<Transaction?>

    suspend fun deleteTransaction(
        transactionId: Long
    ): Result<Unit>
}
