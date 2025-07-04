package ru.ari.fintracker.feature.balance.domain.usecase

import ru.ari.fintracker.core.domain.repository.AccountRepository
import javax.inject.Inject

/**
 * UseCase для получения баланса пользователя
 */
class GetBalanceUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {
    suspend operator fun invoke() = accountRepository.getAccountInfo()
}
