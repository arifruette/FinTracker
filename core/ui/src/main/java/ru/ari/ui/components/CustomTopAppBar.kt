package ru.ari.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    trailingIcon: ImageVector? = null,
    onTrailingIconButtonClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Spacer(Modifier.statusBarsPadding())
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, bottom = 18.dp, start = 4.dp, end = 4.dp)
        ) {
            Text(
                text = title,
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onPrimary)
            )
            IconButton(
                onClick = onTrailingIconButtonClick,
                colors = IconButtonDefaults.iconButtonColors()
                    .copy(contentColor = MaterialTheme.colorScheme.onSurfaceVariant),
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                trailingIcon?.let {
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = null
                    )
                }
            }

        }
    }
}