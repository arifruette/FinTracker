package ru.ari.fintracker.core.domain.repository

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.Transaction
import java.time.LocalDate

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
}
