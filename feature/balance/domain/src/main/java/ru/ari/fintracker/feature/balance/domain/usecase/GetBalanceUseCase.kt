package ru.ari.fintracker.feature.balance.domain.usecase

import ru.ari.fintracker.feature.balance.domain.repository.BalanceRepository
import javax.inject.Inject

/**
 * UseCase для получения баланса пользователя
 */
class GetBalanceUseCase @Inject constructor(
    private val balanceRepository: BalanceRepository
) {
    suspend operator fun invoke() = balanceRepository.getUserBalance()
}
