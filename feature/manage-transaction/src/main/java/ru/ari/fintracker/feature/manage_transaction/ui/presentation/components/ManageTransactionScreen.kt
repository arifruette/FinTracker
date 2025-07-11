package ru.ari.fintracker.feature.manage_transaction.ui.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.ari.fintracker.core.ui.components.DateSelector
import ru.ari.fintracker.core.ui.components.FinTrackerTextField
import ru.ari.fintracker.core.ui.components.ListItem
import ru.ari.fintracker.feature.manage_transaction.R
import ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.contract.ManageTransactionAction
import ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.contract.ManageTransactionAction.ChangeTimePickerVisibility
import ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.contract.ManageTransactionAction.UpdateDate
import ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.contract.ManageTransactionAction.UpdateTime
import ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.contract.ManageTransactionUiState
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun ManageTransactionScreen(
    uiState: ManageTransactionUiState,
    onAction: (ManageTransactionAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        ListItem(
            content = stringResource(R.string.balance_name_label),
            trailingText = uiState.accountName,
            trailingIcon = ImageVector.vectorResource(R.drawable.forward_arrow_icon),
            modifier = Modifier
                .baseFieldModifier()
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = stringResource(R.string.category_picker_label),
            trailingText = uiState.category.name,
            trailingIcon = ImageVector.vectorResource(R.drawable.forward_arrow_icon),
            modifier = Modifier
                .baseFieldModifier()
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        FinTrackerTextField(
            title = stringResource(R.string.price_field_label),
            value = uiState.stringAmount,
            currencySymbol = uiState.currency.symbol,
            modifier = Modifier.baseFieldModifier(),
            isHighlighted = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            ),
            onValueChange = {
                onAction(ManageTransactionAction.UpdateTotalAmount(it))
            }
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = stringResource(R.string.date_picker_label),
            trailingText = uiState.dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
            onItemClick = { onAction(ManageTransactionAction.ChangeDatePickerVisibility) },
            modifier = Modifier
                .baseFieldModifier()
        )
        if (uiState.isDatePickerShown) {
            DateSelector(
                date = uiState.dateTime.toLocalDate(),
                onDismiss = { onAction(ManageTransactionAction.ChangeDatePickerVisibility) },
                onDateSelected = { newDate ->
                    onAction(UpdateDate(newDate))
                }
            )
        }
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = stringResource(R.string.time_picker_label),
            trailingText = uiState.dateTime.format(DateTimeFormatter.ofPattern("HH:mm")),
            onItemClick = { onAction(ChangeTimePickerVisibility) },
            modifier = Modifier
                .baseFieldModifier()
        )
        if (uiState.isTimePickerShown) {
            TimeSelector(
                onCancel = { onAction(ChangeTimePickerVisibility) },
                updateTimeValue = { hour, minute ->
                    onAction(
                        UpdateTime(LocalTime.of(hour, minute))
                    )
                },
                initialTime = uiState.dateTime.toLocalTime()
            )
        }
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        FinTrackerTextField(
            title = stringResource(R.string.description_field_label),
            isHighlighted = false,
            value = uiState.description,
            modifier = Modifier.baseFieldModifier(),
            onValueChange = {
                onAction(ManageTransactionAction.UpdateDescription(it))
            }
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
    }
}

fun Modifier.baseFieldModifier(): Modifier = this.then(
    Modifier
        .height(70.dp)
        .fillMaxWidth()
)