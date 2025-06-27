package ru.ari.fintracker.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.ari.fintracker.core.ui.navigation.Screen

@Composable
fun FinTrackerTopBar(
    route: Screen,
    onTrailingIconClick: () -> Unit,
    modifier: Modifier = Modifier,
    onLeadingIconClick: () -> Unit = {}
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
            route.TopBarLeadingIcon(
                onClick = onLeadingIconClick,
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Text(
                text = route.title,
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onPrimary)
            )
            route.TopBarTrailingIcon(
                onClick = onTrailingIconClick,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}
