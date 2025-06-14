package ru.ari.feature.settings.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SettingsState())

    val uiState: StateFlow<SettingsState> = _uiState.asStateFlow()

    fun toggleDarkTheme() {
        _uiState.value = _uiState.value.copy(
            isDarkTheme = !_uiState.value.isDarkTheme
        )
    }
}