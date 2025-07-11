package ru.ari.fintracker.feature.manage_transaction.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.ari.fintracker.core.common.utils.validator.toValidBalance
import ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.contract.ManageTransactionAction
import ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.contract.ManageTransactionUiState
import java.time.LocalDateTime

class ManageTransactionViewModel @AssistedInject constructor(
    @Assisted private val isIncome: Boolean,
    @Assisted private val transactionId: Long?
): ViewModel() {

    init {
        println(transactionId)
        println(isIncome)
    }

    @AssistedFactory
    interface ViewModelAssistedFactory {
        fun create(isIncomeScreen: Boolean, transactionId: Long?): ManageTransactionViewModel
    }

    private val _uiState = MutableStateFlow(ManageTransactionUiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: ManageTransactionAction) {
        when (action) {
            ManageTransactionAction.ChangeDatePickerVisibility -> _uiState.update {
                it.copy(
                    isDatePickerShown = !it.isDatePickerShown
                )
            }

            ManageTransactionAction.ChangeTimePickerVisibility -> _uiState.update {
                it.copy(isTimePickerShown = !it.isTimePickerShown)
            }

            is ManageTransactionAction.UpdateDate -> _uiState.update {
                it.copy(
                    dateTime = LocalDateTime.of(action.newDate, it.dateTime.toLocalTime())
                )
            }

            is ManageTransactionAction.UpdateDescription -> _uiState.update {
                if (action.newDescription.length < DESCRIPTION_THRESHOLD) {
                    it.copy(description = action.newDescription)
                } else {
                    it
                }
            }

            is ManageTransactionAction.UpdateTime -> _uiState.update {
                it.copy(dateTime = LocalDateTime.of(it.dateTime.toLocalDate(), action.newTime))
            }

            is ManageTransactionAction.UpdateTotalAmount -> _uiState.update {
                it.copy(stringAmount = action.newAmount.toValidBalance())
            }

        }
    }

    private companion object {
        private const val DESCRIPTION_THRESHOLD = 25
    }
}