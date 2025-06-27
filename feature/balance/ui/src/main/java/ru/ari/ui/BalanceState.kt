package ru.ari.ui

import ru.ari.feature.balance.domain.model.Balance

sealed interface BalanceState {
    data object Loading : BalanceState
    data class Success(val balance: Balance) : BalanceState
    data class Error(val message: String) : BalanceState
}
