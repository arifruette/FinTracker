package com.example.core.data.repository

import com.example.core.common.utils.Result
import com.example.core.data.api.TransactionApi
import com.example.core.data.mapper.toDomain
import retrofit2.HttpException
import ru.ari.core.domain.model.Transaction
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
        try {
            val startDateStr = startDate.toString()
            val endDateStr = endDate.toString()
            val response = api.getTransactionsByAccountAndPeriod(
                accountId = accountId,
                startDate = startDateStr,
                endDate = endDateStr
            )
            return Result.Success(response.body()?.map { it.toDomain() } ?: emptyList())
        } catch (e: HttpException) {
            return Result.Error(e.code(), e.message())
        } catch (e: Exception) {
            return Result.Exception(e)
        }
    }
}