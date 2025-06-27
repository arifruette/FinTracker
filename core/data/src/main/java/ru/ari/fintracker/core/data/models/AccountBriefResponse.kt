package ru.ari.fintracker.core.data.models

/**
 * Информация о банковском счёте
 *
 * @property id Уникальный идентификатор счёта
 * @property name Название счёта
 * @property balance Текущий баланс в виде строки
 * @property currency Валюта счёта (RUB, USD)
 */
data class AccountBriefResponse(
    val id: Long,
    val name: String,
    val balance: String,
    val currency: String
)
