package ru.ari.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.ari.feature.categories.ui.R
import ru.ari.ui.CategoriesState
import ru.ari.ui.components.ErrorText
import ru.ari.ui.components.Loading

@Composable
fun CategoriesScreen(
    uiState: CategoriesState,
    modifier: Modifier = Modifier,
) {
    var textFieldState by rememberSaveable { mutableStateOf("") }
    when (uiState) {
        CategoriesState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is CategoriesState.Success -> {
            LaunchedEffect(Unit) {
                textFieldState = uiState.searchTextState
            }
            Column(modifier = modifier) {
                TextField(
                    value = textFieldState,
                    onValueChange = { textFieldState = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "Найти статью",
                            style = MaterialTheme.typography.bodyLarge
                                .copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.search_icon),
                                contentDescription = null
                            )
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.outlineVariant
                    )
                )
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                CategoriesList(
                    categories = uiState.categories
                )
            }
        }

        is CategoriesState.Error -> {
            ErrorText(
                errorMessage = uiState.message,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
