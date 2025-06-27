package ru.ari.ui.viewmodel.contract

import ru.ari.feature.balance.domain.models.Balance

sealed interface BalanceState {
    data object Loading : BalanceState
    data class Success(val balance: Balance) : BalanceState
    data class Error(val message: String) : BalanceState
}