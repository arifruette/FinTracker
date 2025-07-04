package ru.ari.fintracker.core.domain.usecase

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.AccountBrief
import ru.ari.fintracker.core.domain.repository.AccountRepository
import javax.inject.Inject

class GetAccountInfoUseCase @Inject constructor(
    private val accountRepository: AccountRepository
){
    suspend operator fun invoke(): Result<AccountBrief> = accountRepository.getAccountInfo()
}