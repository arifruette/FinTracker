package ru.ari.fintracker.feature.balance.ui.viewmodel.contract

import ru.ari.fintracker.feature.balance.domain.models.Balance

/**
 * Состояния для экрана отображения баланса.
 */
data class BalanceState(
    val isLoading: Boolean = false,
    val balance: Balance = Balance(totalBalance = "0.0", currency = "₽"),
    val error: String? = null
)
