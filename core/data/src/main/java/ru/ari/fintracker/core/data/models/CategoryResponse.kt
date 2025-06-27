package ru.ari.fintracker.core.data.models

data class CategoryResponse(
    val id: Long,
    val name: String,
    val emoji: String,
    val isIncome: Boolean
)
