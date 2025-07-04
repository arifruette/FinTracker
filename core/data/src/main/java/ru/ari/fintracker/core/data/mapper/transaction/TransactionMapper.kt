package ru.ari.fintracker.core.data.mapper.transaction

import ru.ari.fintracker.core.data.models.transaction.TransactionResponse
import ru.ari.fintracker.core.domain.models.Transaction
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun TransactionResponse.toDomain(): Transaction {
    return Transaction(
        id = id,
        account = account.toDomain(),
        category = category.toDomain(),
        amount = amount,
        date = parseDateTime(transactionDate),
        comment = comment
    )
}


private fun parseDateTime(dateTimeString: String): LocalDateTime {
    return try {
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        ZonedDateTime.parse(dateTimeString, formatter)
            .withZoneSameInstant(ZoneId.systemDefault())
            .toLocalDateTime()
    } catch (e: DateTimeParseException) {
        LocalDateTime.now()
    }
}
