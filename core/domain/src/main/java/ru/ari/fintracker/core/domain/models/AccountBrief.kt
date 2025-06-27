package ru.ari.fintracker.core.domain.models

data class AccountBrief(
    val id: Long,
    val name: String,
    val currency: String,
    val balance: String
)
