package ru.ari.fintracker.feature.edit_balance.ui.presentation.components

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class DecimalInputVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val formatted = if (text.text.isEmpty()) {
            "0.00"
        } else {
            val parts = text.text.split('.')
            val integer = parts[0].ifEmpty { "0" }
            val decimal = parts.getOrNull(1)?.take(2)?.padEnd(2, '0') ?: "00"
            "$integer.$decimal"
        }
        
        return TransformedText(
            text = AnnotatedString(formatted),
            offsetMapping = OffsetMapping.Identity
        )
    }
}