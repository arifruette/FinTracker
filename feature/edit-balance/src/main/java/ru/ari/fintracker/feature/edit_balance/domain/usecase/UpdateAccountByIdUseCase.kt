package ru.ari.fintracker.feature.edit_balance.domain.usecase

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.AccountBrief
import ru.ari.fintracker.feature.edit_balance.domain.models.AccountUpdateInfo
import ru.ari.fintracker.feature.edit_balance.domain.repository.AccountEditRepository
import javax.inject.Inject

class UpdateAccountByIdUseCase @Inject constructor(
    private val accountEditRepository: AccountEditRepository
) {
    suspend operator fun invoke(accountId: Long, accountInfo: AccountUpdateInfo): Result<AccountBrief> {
        return accountEditRepository.updateAccountInfo(accountId, accountInfo)
    }
}