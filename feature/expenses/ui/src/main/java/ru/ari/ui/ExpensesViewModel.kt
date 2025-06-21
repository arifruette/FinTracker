package ru.ari.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.common.utils.Result
import com.example.core.common.utils.onError
import com.example.core.common.utils.onException
import com.example.core.common.utils.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ari.feature.expenses.domain.ExpenseData
import ru.ari.feature.expenses.domain.usecase.GetExpensesUseCase
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class ExpensesViewModel @Inject constructor(
    private val getExpensesUseCase: GetExpensesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<ExpensesState>(ExpensesState())
    val state = _state.asStateFlow()

    init {
        getExpenses()
    }

    private fun getExpenses() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = null) }
            withContext(Dispatchers.IO) {
                val result = getExpensesUseCase(
                    accountId = 1
                )
                handleResult(result)
            }
        }
    }

    private fun handleResult(result: Result<ExpenseData>) {
        result
            .onSuccess { expenseData ->
                _state.update {
                    it.copy(
                        expenses = expenseData.expenses,
                        amount = expenseData.amount,
                        currency = expenseData.currency,
                        isLoading = false
                    )
                }
            }
            .onError { code, message ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Ошибка: $message"
                    )
                }
            }
            .onException { error ->
                var message = "Ошибка: Непредвиденная ошибка :("
                if (error is UnknownHostException) {
                    message = "Ошибка подключения к сети"
                }
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = message
                    )
                }
            }
    }
}