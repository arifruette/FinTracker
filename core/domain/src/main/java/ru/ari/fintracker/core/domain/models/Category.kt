package ru.ari.fintracker.core.domain.models

data class Category(
    val id: Long,
    val name: String,
    val emoji: String,
    val isIncome: Boolean
)
