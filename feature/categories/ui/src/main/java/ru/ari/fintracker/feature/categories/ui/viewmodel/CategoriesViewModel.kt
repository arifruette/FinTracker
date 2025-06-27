package ru.ari.fintracker.feature.categories.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ari.fintracker.core.common.utils.onError
import ru.ari.fintracker.core.common.utils.onException
import ru.ari.fintracker.core.common.utils.onSuccess
import ru.ari.fintracker.feature.categories.domain.usecase.GetCategoriesUseCase
import ru.ari.fintracker.feature.categories.ui.viewmodel.contract.CategoriesState
import javax.inject.Inject

/**
 * ViewModel для экрана управления категориями (пока мок)
 */
@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
): ViewModel() {
    private val _state = MutableStateFlow<CategoriesState>(CategoriesState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCategories()
        }
    }

    private suspend fun getCategories() {
        withContext(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            val result = getCategoriesUseCase()
            result.onSuccess { res ->
                _state.update { it.copy(isLoading = false, categories = res) }
            }.onError { code, message ->
                _state.update { it.copy(isLoading = false, error = message) }
            }.onException {
                Log.d("DEBUG", "mockCategories: $it")
            }
        }
    }
}
