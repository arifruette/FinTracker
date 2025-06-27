package ru.ari.fintracker.core.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.ari.fintracker.core.data.models.TransactionResponse

/**
 * API для работы с банковскими транзакциями
 * @param accountId Идентификатор банковского счета (обязательный)
 * @param startDate Начальная дата периода в формате в формате ISO 8601 (обязательный)
 * @param endDate Конечная дата периода в формате в формате ISO 8601 (обязательный)
 *
 * @return [TransactionResponse] обернутый в [Response] класс
 */
interface TransactionApi {
    @GET("transactions/account/{accountId}/period")
    suspend fun getTransactionsByAccountAndPeriod(
        @Path("accountId") accountId: Long,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): Response<List<TransactionResponse>>
}
