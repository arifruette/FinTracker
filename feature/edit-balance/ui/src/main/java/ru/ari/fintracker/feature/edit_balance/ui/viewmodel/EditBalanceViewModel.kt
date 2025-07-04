package ru.ari.fintracker.feature.edit_balance.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.common.utils.format.formatMoney
import ru.ari.fintracker.core.common.utils.onError
import ru.ari.fintracker.core.common.utils.onSuccess
import ru.ari.fintracker.core.domain.models.AccountBrief
import ru.ari.fintracker.core.domain.usecase.GetAccountInfoUseCase
import ru.ari.fintracker.feature.edit_balance.domain.models.AccountUpdateInfo
import ru.ari.fintracker.feature.edit_balance.domain.usecase.UpdateAccountByIdUseCase
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenAction
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenUiEffect
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenUiState
import javax.inject.Inject

@HiltViewModel
class EditBalanceViewModel @Inject constructor(
    private val getAccountInfoUseCase: GetAccountInfoUseCase,
    private val updateAccountByIdUseCase: UpdateAccountByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(EditScreenUiState())
    val uiState = _uiState.asStateFlow()

    private val _uiEffect = MutableSharedFlow<EditScreenUiEffect>()
    val uiEffect = _uiEffect.asSharedFlow()

    init {
        loadAccountInfo()
    }

    fun onAction(action: EditScreenAction) {
        when (action) {
            is EditScreenAction.UpdateAccountInfo -> updateAccountInfo(action.onSuccess)
            is EditScreenAction.ChangeAccountName -> _uiState.update {
                it.copy(accountName = action.newName)
            }

            is EditScreenAction.ChangeAccountAmount -> updateBalance(action.newAmount)
            is EditScreenAction.ChangeAccountCurrency -> _uiState.update {
                it.copy(currency = action.newCurrency)
            }

            EditScreenAction.ChangeBottomSheetVisibility -> _uiState.update {
                it.copy(
                    isBottomSheetShown = !it.isBottomSheetShown
                )
            }
        }
    }

    private fun loadAccountInfo() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _uiState.update { it.copy(isLoading = true) }
                val accountInfoResult = getAccountInfoUseCase()
                when (accountInfoResult) {
                    is Result.Error -> _uiEffect.emit(EditScreenUiEffect.ShowError(accountInfoResult.message))
                    is Result.Exception -> Log.e("FATAL ERROR", accountInfoResult.error.toString())
                    is Result.Success<AccountBrief> -> {
                        val accountData = accountInfoResult.data
                        Log.d("SUCCESS", "loadAccountInfo: $accountData")
                        _uiState.update {
                            it.copy(
                                accountId = accountData.id,
                                amountInput = formatMoney(accountData.balance, withSpaces = false),
                                currency = accountData.currency,
                                accountName = accountData.name
                            )
                        }
                    }
                }
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    private fun updateAccountInfo(onSuccess: () -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val state = _uiState.value
                updateAccountByIdUseCase(
                    state.accountId,
                    accountInfo = AccountUpdateInfo(
                        name = state.accountName,
                        balance = state.amountInput,
                        currency = state.currency.name
                    )
                ).onSuccess {
                    Log.d("DEBUG", "$it")
                    withContext(Dispatchers.Main.immediate) {
                        onSuccess()
                    }
                }.onError { c, m ->
                    _uiEffect.emit(EditScreenUiEffect.ShowError("Не удалось обновить счет"))
                }
            }
        }
    }

    private fun updateBalance(newBalance: String) {
        val cleaned = newBalance.replace(" ", "")

        val isNegative = cleaned.startsWith("-")
        val unsigned = if (isNegative) cleaned.drop(1) else cleaned

        val filtered = unsigned
            .filterIndexed { index, c ->
                c.isDigit() || (c == '.' && !unsigned.take(index).contains('.'))
            }
            .let { filteredInput ->
                val parts = filteredInput.split(".")
                val intPart = parts[0].take(13)
                val decPart = parts.getOrNull(1)?.take(2)
                if (decPart != null) "$intPart.$decPart" else intPart
            }
            .let { final ->
                if (isNegative) "-$final" else final
            }

        val isPartialNegative = newBalance == "-" || newBalance == "-."
        val result = if (isPartialNegative) newBalance else filtered

        _uiState.update { it.copy(amountInput = result) }
    }


}