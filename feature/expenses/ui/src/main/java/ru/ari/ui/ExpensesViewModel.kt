package ru.ari.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ari.feature.expenses.domain.Expense

class ExpensesViewModel : ViewModel() {
    private val _state = MutableStateFlow<ExpensesState>(ExpensesState.Loading)
    val state = _state.asStateFlow()

    init {
        mockExpenses()
    }

    private fun mockExpenses() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = ExpensesState.Loading
                delay(MOCK_DELAY_MILLIS)
                _state.value = ExpensesState.Success(
                    totalAmount = "436 558 ₽",
                    expenses = listOf(
                        mockExpense(1, "\uD83C\uDFE0", "Аренда квартиры", "100 000 ₽", null),
                        mockExpense(2, "\uD83D\uDC57", "Одежда", "100 000 ₽", null),
                        mockExpense(3, "\uD83D\uDC36", "На собачку", "100 000 ₽", "Джек"),
                        mockExpense(4, "\uD83D\uDC36", "На собачку", "100 000 ₽", "Энни"),
                        mockExpense(5, "РК", "Ремонт квартиры", "100 000 ₽", null),
                        mockExpense(6, "\uD83C\uDF6D", "Продукты", "100 000 ₽", null),
                        mockExpense(7, "\uD83C\uDFCB\uFE0F", "Спортзал", "100 000 ₽", null),
                        mockExpense(8, "\uD83D\uDC8A", "Медицина", "100 000 ₽", null)
                    )
                )
            }
        }
    }

    private fun mockExpense(
        id: Int,
        icon: String,
        title: String,
        amount: String,
        comment: String?
    ): Expense {
        return Expense(
            id = id,
            icon = icon,
            content = title,
            amount = amount,
            comment = comment
        )
    }

    private companion object {
        const val MOCK_DELAY_MILLIS = 1000L
    }
}