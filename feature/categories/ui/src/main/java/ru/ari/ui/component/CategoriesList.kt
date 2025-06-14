package ru.ari.ui.component

import ListItem
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.ari.domain.model.Category

@Composable
fun CategoriesList(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            categories,
            key = { it.id }
        ) { category ->
            ListItem(
                content = category.name,
                leadEmoji = category.icon,
                modifier = Modifier.height(70.dp)
            )
            HorizontalDivider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }
    }
}