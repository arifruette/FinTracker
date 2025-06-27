package ru.ari.core.domain.repository

import com.example.core.common.utils.Result
import ru.ari.core.domain.models.Transaction
import java.time.LocalDate

interface TransactionRepository {
    suspend fun getTransactions(
        startDate: LocalDate,
        endDate: LocalDate,
        accountId: Long
    ): Result<List<Transaction>>
}
