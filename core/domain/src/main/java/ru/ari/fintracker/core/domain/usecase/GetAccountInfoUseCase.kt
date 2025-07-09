package ru.ari.fintracker.core.domain.usecase

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.AccountBrief
import ru.ari.fintracker.core.domain.repository.AccountRepository

class GetAccountInfoUseCase(
    private val accountRepository: AccountRepository
){
    suspend operator fun invoke(): Result<AccountBrief> = accountRepository.getAccountInfo()
}