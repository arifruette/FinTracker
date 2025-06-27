package ru.ari.fintracker.core.domain.repository

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.Transaction
import java.time.LocalDate

interface TransactionRepository {
    suspend fun getTransactions(
        startDate: LocalDate,
        endDate: LocalDate,
        accountId: Long
    ): Result<List<Transaction>>
}
