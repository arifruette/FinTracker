package ru.ari.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ari.feature.balance.domain.models.Balance
import ru.ari.ui.viewmodel.contract.BalanceState

class BalanceViewModel : ViewModel() {
    private var _state = MutableStateFlow<BalanceState>(BalanceState.Loading)
    val state = _state.asStateFlow()

    init {
        loadMockData()
    }

    private fun loadMockData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = BalanceState.Loading
                delay(MOCK_DELAY_MILLIS)

                _state.value = BalanceState.Success(
                    Balance(
                        totalBalance = "-670 000 ₽",
                        currency = "₽"
                    )
                )
            }
        }
    }

    private companion object {
        const val MOCK_DELAY_MILLIS = 800L
    }
}