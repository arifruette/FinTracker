package com.example.core.data.repository

import com.example.core.common.utils.Result
import com.example.core.data.api.TransactionApi
import com.example.core.data.mapper.toDomain
import retrofit2.HttpException
import ru.ari.core.domain.models.Transaction
import ru.ari.core.domain.repository.TransactionRepository
import java.time.LocalDate
import javax.inject.Inject

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
