package com.example.feature.history.domain.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun formatMoney(amount: Double, currencySymbol: String = ""): String {
    val formatter = DecimalFormat("#,###.00", DecimalFormatSymbols(Locale.getDefault())).apply {
        decimalFormatSymbols = DecimalFormatSymbols(Locale.getDefault()).apply {
            groupingSeparator = ' '
            decimalSeparator = '.'
        }
        isGroupingUsed = true
    }

    val formatted = formatter.format(amount)
    return "$formatted $currencySymbol".trim()
}