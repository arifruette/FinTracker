package com.example.core.data.api

import com.example.core.data.models.TransactionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TransactionApi {
    @GET("transactions/account/{accountId}/period")
    suspend fun getTransactionsByAccountAndPeriod(
        @Path("accountId") accountId: Long,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): Response<List<TransactionResponse>>
}
