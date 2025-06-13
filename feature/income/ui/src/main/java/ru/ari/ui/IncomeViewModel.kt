package ru.ari.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ari.feature.income.domain.model.Income

class IncomesViewModel : ViewModel() {
    private val _state = MutableStateFlow<IncomeState>(IncomeState.Loading)
    val state = _state.asStateFlow()

    init {
        mockIncomes()
    }

    private fun mockIncomes() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = IncomeState.Loading
                delay(MOCK_DELAY_MILLIS)

                val incomes = listOf(
                    mockIncome(1, "Зарплата", "500 000 ₽"),
                    mockIncome(2, "Подработка", "100 000 ₽")
                )

                val totalAmount = "600 000 ₽"

                _state.value = IncomeState.Success(
                    totalAmount = totalAmount,
                    incomes = incomes
                )
            }
        }
    }

    private fun mockIncome(
        id: Int,
        title: String,
        amount: String,
        comment: String? = null
    ): Income {
        return Income(
            id = id,
            content = title,
            amount = amount,
            comment = comment
        )
    }

    private companion object {
        const val MOCK_DELAY_MILLIS = 1000L
    }
}