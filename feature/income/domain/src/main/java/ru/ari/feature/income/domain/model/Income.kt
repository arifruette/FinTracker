package ru.ari.feature.income.domain.model

data class Income(
    val id: Int,
    val content: String,
    val amount: String,
    val comment: String? = null
)