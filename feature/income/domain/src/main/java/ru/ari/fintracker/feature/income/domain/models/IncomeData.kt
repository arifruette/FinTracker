package ru.ari.fintracker.feature.income.domain.models

import ru.ari.fintracker.core.domain.models.Transaction

/**
 * Модель данных, содержащая информацию о доходах.
 *
 * @property income список доходных транзакций
 * @property amount общая сумма доходов
 * @property currency валюта доходов (символ)
 */
data class IncomeData(
    val income: List<Transaction>,
    val amount: Double,
    val currency: String
)
