package ru.ari.ui.viewmodel.contract

import ru.ari.core.domain.models.Transaction

data class ExpensesState(
    val expenses: List<Transaction> = emptyList(),
    val amount: Double = 0.0,
    val currency: String = "₽",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
