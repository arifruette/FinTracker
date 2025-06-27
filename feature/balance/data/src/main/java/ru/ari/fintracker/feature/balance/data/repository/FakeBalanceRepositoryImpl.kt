package ru.ari.fintracker.feature.balance.data.repository

import kotlinx.coroutines.delay
import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.feature.balance.domain.models.Balance
import ru.ari.fintracker.feature.balance.domain.repository.BalanceRepository
import javax.inject.Inject

/**
 * Фейк реализация [BalanceRepository]
 */
class FakeBalanceRepositoryImpl @Inject constructor(

): BalanceRepository {
    override suspend fun getUserBalance(): Result<Balance> {
        delay(MOCK_DELAY_MILLIS)
        return Result.Success(
            Balance(
                totalBalance = "-670 000 ₽",
                currency = "₽"
            )
        )
    }
    private companion object {
        const val MOCK_DELAY_MILLIS = 800L
    }
}
