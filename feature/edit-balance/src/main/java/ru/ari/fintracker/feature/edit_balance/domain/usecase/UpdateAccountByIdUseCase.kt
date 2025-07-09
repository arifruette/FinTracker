package ru.ari.fintracker.feature.edit_balance.domain.usecase

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.account.AccountBrief
import ru.ari.fintracker.core.domain.models.account.AccountUpdateInfo
import ru.ari.fintracker.core.domain.repository.AccountRepository
import javax.inject.Inject

class UpdateAccountByIdUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {
    suspend operator fun invoke(accountId: Long, accountInfo: AccountUpdateInfo): Result<AccountBrief> {
        return accountRepository.updateAccountInfo(accountId, accountInfo)
    }
}