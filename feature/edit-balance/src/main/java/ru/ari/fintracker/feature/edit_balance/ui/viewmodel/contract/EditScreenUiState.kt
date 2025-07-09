package ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract

import ru.ari.fintracker.core.domain.models.account.Currency

data class EditScreenUiState(
    val isLoading: Boolean = false,
    val accountId: Long = 1L,
    val currency: Currency = Currency.RUB,
    val isBottomSheetShown: Boolean = false,
    val amountInput: String = "0.00",
    val accountName: String = "Мой счет"
)