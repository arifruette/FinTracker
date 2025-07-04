package ru.ari.fintracker.feature.history.domain.models

import ru.ari.fintracker.core.domain.models.Currency
import ru.ari.fintracker.core.domain.models.Transaction

/**
 * Модель данных, представляющая историю транзакций за определенный период
 *
 * @property transactions Список транзакций за период
 * @property amount Итоговый финансовый результат
 * @property currency Символ валюты для форматирования
 */
data class HistoryData(
    val transactions: List<Transaction> = emptyList(),
    val amount: Double = 0.0,
    val currency: Currency = Currency.RUB
)
