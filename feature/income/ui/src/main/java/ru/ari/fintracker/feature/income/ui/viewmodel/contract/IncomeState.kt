package ru.ari.fintracker.feature.income.ui.viewmodel.contract

import ru.ari.fintracker.core.domain.models.Transaction

/**
 * Состояние UI для экрана доходов
 *
 * @property incomes список доходных транзакций
 * @property amount общая сумма доходов
 * @property currency отображаемый символ валюты
 * @property isLoading флаг загрузки данных (true - идёт загрузка)
 * @property errorMessage текст ошибки (null при отсутствии ошибок)
 */
data class IncomeState(
    val incomes: List<Transaction> = emptyList(),
    val amount: Double = 0.0,
    val currency: String = "₽",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
