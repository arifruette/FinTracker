package ru.ari.fintracker.core.common.utils.format

import java.time.LocalDateTime

fun formatTimeWithLeadingZero(dateTime: LocalDateTime): String {
    val hour = dateTime.hour
    val minute = dateTime.minute

    val hourFormatted = if (hour < 10) "0$hour" else "$hour"
    val minuteFormatted = if (minute < 10) "0$minute" else "$minute"

    return "$hourFormatted:$minuteFormatted"
}
