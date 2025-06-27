package ru.ari.fintracker.core.data.models


data class AccountBriefResponse(
    val id: Long,
    val name: String,
    val balance: String,
    val currency: String
)
