package ru.ari.core.domain.model

data class Category(
    val id: Long,
    val name: String,
    val emoji: String,
    val isIncome: Boolean
)
