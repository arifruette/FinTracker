package ru.ari.feature.expenses.domain

data class Expense(
    val id: Int,
    val icon: String,
    val content: String,
    val amount: String,
    val comment: String?
)
