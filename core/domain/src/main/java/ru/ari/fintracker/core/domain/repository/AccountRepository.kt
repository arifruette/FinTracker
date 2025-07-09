package ru.ari.fintracker.core.domain.repository

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.account.AccountBrief
import ru.ari.fintracker.core.domain.models.account.AccountUpdateInfo

interface AccountRepository {
    suspend fun getAccountInfo(): Result<AccountBrief>
    suspend fun updateAccountInfo(accountId: Long, info: AccountUpdateInfo): Result<AccountBrief>

}