package ru.ari.fintracker.feature.expenses.domain.models

import ru.ari.fintracker.core.domain.models.account.Currency
import ru.ari.fintracker.core.domain.models.transaction.Transaction

/**
 * Модель данных, представляющая нужную информацию о расходах
 *
 * @property expenses Список расходных операций
 * @property amount Итоговая сумма расходов
 * @property currency Символ валюты для форматированного вывода
 */
data class ExpenseData(
    val expenses: List<Transaction> = emptyList<Transaction>(),
    val amount: Double = 0.0,
    val currency: Currency = Currency.RUB
)
