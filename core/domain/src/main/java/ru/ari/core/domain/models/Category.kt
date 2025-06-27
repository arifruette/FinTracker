package ru.ari.core.domain.models

data class Category(
    val id: Long,
    val name: String,
    val emoji: String,
    val isIncome: Boolean
)
