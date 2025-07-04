package ru.ari.fintracker.feature.edit_balance.ui.presentation.components

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow
import ru.ari.fintracker.core.ui.components.ListItem
import ru.ari.fintracker.core.ui.components.Loading
import ru.ari.fintracker.feature.edit_balance.ui.R
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenAction
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenAction.ChangeAccountAmount
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenAction.ChangeAccountCurrency
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenAction.ChangeAccountName
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenAction.ChangeBottomSheetVisibility
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenUiEffect
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract.EditScreenUiState

@Composable
fun EditBalanceScreen(
    modifier: Modifier = Modifier,
    uiState: EditScreenUiState,
    uiEffect: Flow<EditScreenUiEffect>,
    onAction: (EditScreenAction) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        uiEffect.collect { effect ->
            when (effect) {
                is EditScreenUiEffect.ShowError -> Toast.makeText(
                    context,
                    effect.message,
                    LENGTH_SHORT
                ).show()
            }
        }
    }
    when {
        uiState.isLoading -> Loading(modifier = modifier.fillMaxSize())
        else -> {
            Column(modifier = modifier) {
                FinTrackerTextField(
                    title = "Название счета",
                    value = uiState.accountName,
                    onValueChange = {
                        if (it.length < 25) {
                            onAction(ChangeAccountName(it))
                        }
                    }
                )
                HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
                FinTrackerTextField(
                    title = "Баланс",
                    value = uiState.amountInput,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Done
                    ),
                    onValueChange = {
                        onAction(ChangeAccountAmount(it))
                    }
                )
                HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
                ListItem(
                    content = "Валюта",
                    trailingText = uiState.currency.symbol,
                    trailingIcon = ImageVector.vectorResource(R.drawable.forward_arrow_icon),
                    onItemClick = { onAction(ChangeBottomSheetVisibility) },
                    isHighlighted = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                )
                HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
            }
            if (uiState.isBottomSheetShown) {
                FinTrackerBottomSheet(onDismiss = {
                    onAction(ChangeBottomSheetVisibility)
                }, onCurrencyClicked = {
                    onAction(ChangeAccountCurrency(it))
                })
            }
        }
    }
}