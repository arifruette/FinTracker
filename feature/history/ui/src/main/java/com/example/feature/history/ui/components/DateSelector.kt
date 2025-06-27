import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.time.LocalDate
import java.time.ZoneOffset

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateSelector(
    label: String,
    date: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {
    var showDatePicker by remember { mutableStateOf(false) }

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()
    )

    ListItem(
        modifier = modifier,
        isHighlighted = true,
        content = label,
        onItemClick = { showDatePicker = true },
        trailingText = date.formatForDisplay()
    )

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            onDateSelected(millis.toLocalDate())
                        }
                        showDatePicker = false
                    }
                ) {
                    Text("OK", color = Color.Black)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Отмена", color = Color.Black)
                }
            },
            colors = DatePickerDefaults.colors().copy(containerColor = Color(0xFFD4FAE6))
        ) {
            DatePicker(
                state = datePickerState,
                title = null,
                headline = null,
                showModeToggle = false,
                colors = DatePickerDefaults.colors(
                    containerColor = Color(0xFFD4FAE6),
                    selectedDayContainerColor = MaterialTheme.colorScheme.primary,
                    selectedDayContentColor = Color.Black,
                    todayContentColor = Color.Black,
                    navigationContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                ),
            )
        }
    }
}

fun Long.toLocalDate(): LocalDate {
    return java.time.Instant.ofEpochMilli(this)
        .atZone(java.time.ZoneId.systemDefault())
        .toLocalDate()
}

fun LocalDate.formatForDisplay(): String {
    return format(java.time.format.DateTimeFormatter.ofPattern("dd MMM yyyy"))
}
