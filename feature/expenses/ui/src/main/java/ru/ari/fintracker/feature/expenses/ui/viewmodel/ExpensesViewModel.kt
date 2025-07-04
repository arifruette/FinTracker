package ru.ari.fintracker.feature.expenses.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.common.utils.onError
import ru.ari.fintracker.core.common.utils.onException
import ru.ari.fintracker.core.common.utils.onSuccess
import ru.ari.fintracker.core.domain.usecase.GetAccountInfoUseCase
import ru.ari.fintracker.feature.expenses.domain.models.ExpenseData
import ru.ari.fintracker.feature.expenses.domain.usecase.GetExpensesUseCase
import ru.ari.fintracker.feature.expenses.ui.viewmodel.contract.ExpensesState
import java.net.UnknownHostException
import javax.inject.Inject

/**
 * ViewModel для экрана расходов, управляющая ui состоянием
 * @param getExpensesUseCase UseCase получения данных о расходах
 */
@HiltViewModel
class ExpensesViewModel @Inject constructor(
    private val getExpensesUseCase: GetExpensesUseCase,
    private val getAccountInfoUseCase: GetAccountInfoUseCase
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
                var result: Result<ExpenseData> = Result.Success<ExpenseData>(ExpenseData())
                getAccountInfoUseCase().onSuccess {
                    result = getExpensesUseCase(it.id)
                }.onError { code, message ->
                    result = Result.Error(code, message)
                }.onException {
                    result = Result.Exception(it)
                }
                handleResult(result)
            }
        }
    }

    private fun handleResult(result: Result<ExpenseData>) {
        result.onSuccess { expenseData ->
            _state.update {
                it.copy(
                    expenses = expenseData.expenses,
                    amount = expenseData.amount,
                    currency = expenseData.currency.symbol,
                    isLoading = false
                )
            }
        }.onError { code, message ->
            _state.update {
                it.copy(
                    isLoading = false,
                    errorMessage = "Ошибка: $message"
                )
            }
        }.onException { error ->
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
