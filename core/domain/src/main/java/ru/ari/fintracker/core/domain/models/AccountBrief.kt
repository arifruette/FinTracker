package ru.ari.fintracker.core.domain.models

/**
 * Информация о банковском счёте
 *
 * @property id Уникальный идентификатор счёта
 * @property name Название счёта
 * @property currency Валюта счёта (RUB, EUR)
 * @property balance Текущий баланс в виде строки
 */
data class AccountBrief(
    val id: Long,
    val name: String,
    val currency: String,
    val balance: String
)
