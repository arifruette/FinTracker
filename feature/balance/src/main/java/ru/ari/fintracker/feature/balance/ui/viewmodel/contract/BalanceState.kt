package ru.ari.fintracker.feature.balance.ui.viewmodel.contract

import ru.ari.fintracker.core.domain.models.account.Currency

/**
 * Состояния для экрана отображения баланса.
 */
data class BalanceState(
    val isLoading: Boolean = false,
    val amount: String = "0.00",
    val currency: Currency = Currency.RUB,
    val accountName: String = "",
    val error: String? = null
)
