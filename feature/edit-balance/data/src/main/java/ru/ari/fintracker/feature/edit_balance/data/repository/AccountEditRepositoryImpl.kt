package ru.ari.fintracker.feature.edit_balance.data.repository

import retrofit2.HttpException
import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.AccountBrief
import ru.ari.fintracker.feature.edit_balance.data.api.AccountEditApi
import ru.ari.fintracker.feature.edit_balance.data.mapper.toDomain
import ru.ari.fintracker.feature.edit_balance.domain.models.AccountUpdateInfo
import ru.ari.fintracker.feature.edit_balance.domain.repository.AccountEditRepository
import javax.inject.Inject

class AccountEditRepositoryImpl @Inject constructor(
    private val accountApi: AccountEditApi
) : AccountEditRepository {
    override suspend fun updateAccountInfo(
        accountId: Long,
        info: AccountUpdateInfo
    ): Result<AccountBrief> {
        return try {
            Result.Success(
                accountApi.updateAccountById(accountId, info).body()?.toDomain()
                    ?: AccountBrief.empty()
            )
        } catch (e: HttpException) {
            Result.Error(e.code(), e.message())
        } catch (e: Throwable) {
            Result.Exception(e)
        }
    }
}