package ru.ari.fintracker.core.data.repository

import android.util.Log
import retrofit2.HttpException
import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.data.api.AccountApi
import ru.ari.fintracker.core.data.mapper.account.toDomain
import ru.ari.fintracker.core.domain.models.account.AccountBrief
import ru.ari.fintracker.core.domain.models.account.AccountUpdateInfo
import ru.ari.fintracker.core.domain.repository.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountApi: AccountApi
): AccountRepository {
    override suspend fun getAccountInfo(): Result<AccountBrief> {
        return try {
            val resp = accountApi.getAllUsersAccounts()
            val accountBrief = resp.body()?.getOrNull(0)?.toDomain()
            accountBrief?.let {
                Result.Success(it)
            } ?: Result.Error(1, "Не удалось найти информацию о счетах пользователя")
        } catch(e: HttpException) {
            Result.Error(e.code(), e.message())
        } catch (e: Throwable) {
            Result.Exception(e)
        }
    }

    override suspend fun updateAccountInfo(
        accountId: Long,
        info: AccountUpdateInfo
    ): Result<AccountBrief> {
        Log.d("DEBUG", "$info")
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