package ru.ari.fintracker.core.data.api

import retrofit2.Response
import retrofit2.http.GET
import ru.ari.fintracker.core.data.models.account.AccountExtendedInfoResponse

interface AccountApi {
    @GET("accounts")
    suspend fun getAllUsersAccounts(): Response<List<AccountExtendedInfoResponse>>
}