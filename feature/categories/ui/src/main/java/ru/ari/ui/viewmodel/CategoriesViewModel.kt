package ru.ari.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ari.domain.models.Category
import ru.ari.ui.viewmodel.contract.CategoriesState

class CategoriesViewModel : ViewModel() {
    private val _state = MutableStateFlow<CategoriesState>(CategoriesState.Loading)
    val state = _state.asStateFlow()

    init {
        mockCategories()
    }

    private fun mockCategories() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = CategoriesState.Loading
                delay(MOCK_DELAY_MILLIS)
                _state.value = CategoriesState.Success(
                    categories = listOf(
                        mockCategory(1, "\uD83C\uDFE0", "Аренда квартиры"),
                        mockCategory(2, "\uD83D\uDC57", "Одежда"),
                        mockCategory(3, "\uD83D\uDC36", "На собачку"),
                        mockCategory(4, "\uD83D\uDC36", "На собачку"),
                        mockCategory(5, "РК", "Ремонт квартиры"),
                        mockCategory(6, "\uD83C\uDF6D", "Продукты"),
                        mockCategory(7, "\uD83C\uDFCB\uFE0F", "Спортзал"),
                        mockCategory(8, "\uD83D\uDC8A", "Медицина")
                    ),
                    searchTextState = ""
                )
            }
        }
    }

    private fun mockCategory(
        id: Int,
        icon: String,
        name: String,
    ): Category {
        return Category(
            id = id,
            icon = icon,
            name = name
        )
    }

    private companion object {
        const val MOCK_DELAY_MILLIS = 1000L
    }
}