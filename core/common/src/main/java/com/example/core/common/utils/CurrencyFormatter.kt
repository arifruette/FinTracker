package com.example.core.common.utils

fun String.toCurrencySymbol() = when (this) {
    "RUB" -> "\u20BD"
    "USD" -> "\u0024"
    "EUR" -> "\u20AC"
    else -> "\u20BD"
}