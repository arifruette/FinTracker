package ru.ari.feature.settings.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel: ViewModel() {
    private val _state = MutableStateFlow(SettingsState())

    val state: StateFlow<SettingsState> = _state.asStateFlow()

    fun toggleDarkTheme() {
        _state.value = _state.value.copy(
            isDarkTheme = !_state.value.isDarkTheme
        )
    }
}