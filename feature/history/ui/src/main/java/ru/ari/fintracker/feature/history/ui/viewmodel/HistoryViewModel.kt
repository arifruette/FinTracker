package ru.ari.fintracker.feature.history.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.common.utils.onError
import ru.ari.fintracker.core.common.utils.onException
import ru.ari.fintracker.core.common.utils.onSuccess
import ru.ari.fintracker.core.domain.models.TransactionType
import ru.ari.fintracker.feature.history.domain.models.HistoryData
import ru.ari.fintracker.feature.history.domain.usecase.GetHistoryUseCase
import ru.ari.fintracker.feature.history.ui.viewmodel.contract.HistoryAction
import ru.ari.fintracker.feature.history.ui.viewmodel.contract.HistoryState
import java.net.UnknownHostException
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getHistoryUseCase: GetHistoryUseCase
) : ViewModel() {

    var transactionType: TransactionType = TransactionType.EXPENSE

    private val _state: MutableStateFlow<HistoryState> = MutableStateFlow(HistoryState())
    val state: StateFlow<HistoryState> = _state.asStateFlow()

    fun onAction(action: HistoryAction) {
        when (action) {
            HistoryAction.LoadTransactions -> loadTransactions()
            is HistoryAction.UpdateDateEnd -> updateDateEnd(action.date)
            is HistoryAction.UpdateDateStart -> updateDateStart(action.date)
        }
    }

    private fun loadTransactions() {
        val state = _state.value

        _state.update { it.copy(isLoading = true, errorMessage = null) }

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = getHistoryUseCase(
                    startDate = state.dateStart,
                    endDate = state.dateEnd,
                    accountId = MOCK_ACCOUNT_ID,
                    transactionType = transactionType
                )
                handleResult(result)
            }
        }
    }

    private fun handleResult(result: Result<HistoryData>) {
        result.onSuccess { historyData ->
                _state.update {
                    it.copy(
                        transactions = historyData.transactions,
                        amount = historyData.amount,
                        currency = historyData.currency,
                        isLoading = false
                    )
                }
            }.onError { code, message ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Ошибка $code: $message"
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

    private fun updateDateEnd(dateEnd: LocalDate) {
        _state.update { state ->
            val newEnd = if (dateEnd.isBefore(state.dateStart)) state.dateStart else dateEnd
            state.copy(dateEnd = newEnd)
        }
        loadTransactions()
    }

    private fun updateDateStart(dateStart: LocalDate) {
        _state.update { state ->
            val newStart = if (dateStart.isAfter(state.dateEnd)) state.dateEnd else dateStart
            state.copy(dateStart = newStart)
        }
        loadTransactions()
    }

    private companion object {
        private const val MOCK_ACCOUNT_ID = 1L
    }
}
