package ru.ari.fintracker.feature.balance.domain.repository

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.feature.balance.domain.models.Balance

/**
 * Интерфейс описывающий бизнес правила для работы с балансом
 */
interface BalanceRepository {
    suspend fun getUserBalance(): Result<Balance>
}
