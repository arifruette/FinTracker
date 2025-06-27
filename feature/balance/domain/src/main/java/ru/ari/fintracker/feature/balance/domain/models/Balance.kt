package ru.ari.fintracker.feature.balance.domain.models


/**
 * Модель для представления баланса счёта
 *
 * @property totalBalance Сумма баланса в виде строки
 * @property currency Код валюты
 */
data class Balance(
    val totalBalance: String,
    val currency: String
)

