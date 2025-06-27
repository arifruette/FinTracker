package ru.ari.fintracker.feature.expenses.domain.models

import ru.ari.fintracker.core.domain.models.Transaction

/**
 * Модель данных, представляющая нужную информацию о расходах
 *
 * @property expenses Список расходных операций
 * @property amount Итоговая сумма расходов
 * @property currency Символ валюты для форматированного вывода
 */
data class ExpenseData(
    val expenses: List<Transaction>,
    val amount: Double,
    val currency: String
)
