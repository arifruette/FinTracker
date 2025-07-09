package ru.ari.fintracker.core.data.repository

import retrofit2.HttpException
import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.data.api.TransactionApi
import ru.ari.fintracker.core.data.mapper.transaction.toDomain
import ru.ari.fintracker.core.domain.models.transaction.Transaction
import ru.ari.fintracker.core.domain.repository.TransactionRepository
import java.time.LocalDate
import javax.inject.Inject

/**
 * Реализация репозитория для работы с транзакциями.
 * @param api Сетевой клиент для работы с API транзакций
 */
class TransactionRepositoryImpl @Inject constructor(
    private val api: TransactionApi
) : TransactionRepository {

    override suspend fun getTransactions(
        startDate: LocalDate,
        endDate: LocalDate,
        accountId: Long
    ): Result<List<Transaction>> {
        return try {
            val startDateStr = startDate.toString()
            val endDateStr = endDate.toString()
            val response = api.getTransactionsByAccountAndPeriod(
                accountId = accountId,
                startDate = startDateStr,
                endDate = endDateStr
            )
            Result.Success(response.body()?.map { it.toDomain() } ?: emptyList())
        } catch (e: HttpException) {
            Result.Error(e.code(), e.message())
        } catch (e: Throwable) {
            Result.Exception(e)
        }
    }
}
