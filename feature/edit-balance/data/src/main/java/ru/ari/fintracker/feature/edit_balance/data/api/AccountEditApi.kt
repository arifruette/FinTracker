package ru.ari.fintracker.feature.edit_balance.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path
import ru.ari.fintracker.feature.edit_balance.data.models.AccountExtendedInfoResponse
import ru.ari.fintracker.feature.edit_balance.domain.models.AccountUpdateInfo

interface AccountEditApi {

    @PUT("accounts/{id}")
    suspend fun updateAccountById(
        @Path("id") id: Long,
        @Body updateInfo: AccountUpdateInfo
    ): Response<AccountExtendedInfoResponse>
}