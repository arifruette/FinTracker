package ru.ari.fintracker.feature.edit_balance.domain.repository

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.AccountBrief
import ru.ari.fintracker.feature.edit_balance.domain.models.AccountUpdateInfo

interface AccountEditRepository {
    suspend fun updateAccountInfo(accountId: Long, info: AccountUpdateInfo): Result<AccountBrief>
}