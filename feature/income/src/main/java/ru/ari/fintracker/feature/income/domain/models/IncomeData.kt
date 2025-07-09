package ru.ari.fintracker.feature.income.domain.models

import ru.ari.fintracker.core.domain.models.account.Currency
import ru.ari.fintracker.core.domain.models.transaction.Transaction

/**
 * Модель данных, содержащая информацию о доходах.
 *
 * @property income список доходных транзакций
 * @property amount общая сумма доходов
 * @property currency валюта доходов (символ)
 */
data class IncomeData(
    val income: List<Transaction> = emptyList(),
    val amount: Double = 0.0,
    val currency: Currency = Currency.RUB
)
