package ru.ari.fintracker.core.domain.repository

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.AccountBrief

interface AccountRepository {
    suspend fun getAccountInfo(): Result<AccountBrief>
}