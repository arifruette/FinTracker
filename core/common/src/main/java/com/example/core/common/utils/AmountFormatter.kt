package com.example.core.common.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun formatMoney(amount: Double, currencySymbol: String = ""): String {
    val symbols = DecimalFormatSymbols(Locale.getDefault()).apply {
        groupingSeparator = ' '
        decimalSeparator = '.'
    }

    val formatter = DecimalFormat("#,##0.00", symbols).apply {
        isGroupingUsed = true
    }

    val formatted = formatter.format(amount)
    return "$formatted $currencySymbol".trim()
}
