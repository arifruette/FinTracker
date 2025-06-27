package ru.ari.fintracker.feature.expenses.ui.viewmodel.contract
import ru.ari.fintracker.core.domain.models.Transaction

data class ExpensesState(
    val expenses: List<Transaction> = emptyList(),
    val amount: Double = 0.0,
    val currency: String = "₽",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
