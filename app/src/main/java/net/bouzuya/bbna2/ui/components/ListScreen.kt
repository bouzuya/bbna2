package net.bouzuya.bbna2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    onNavigateToDetail: (entryId: String) -> Unit
) {
    val entries = (0..100).map {
        Entry(
            date = LocalDate.of(2020, 1, 2).plusDays(it.toLong()).toString(),
            title = "Title $it"
        )
    }.toList()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    Icon(
                        Icons.Outlined.Menu,
                        contentDescription = null,
                    )
                },
                title = { Text("blog.bouzuya.net") })
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxSize(),
        ) {
            item {
                EntryListItem(
                    entry = Entry(
                        date = "2020-01-01",
                        title = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"
                    ),
                    onNavigateToDetail = onNavigateToDetail
                )
            }

            items(entries) {
                EntryListItem(
                    entry = it,
                    onNavigateToDetail = onNavigateToDetail
                )
            }
        }
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ListScreen { }
}

data class Entry(val date: String, val title: String)

@Composable
fun EntryListItem(entry: Entry, onNavigateToDetail: (entryId: String) -> Unit) {
    Column(
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        modifier = Modifier
            .clickable { onNavigateToDetail(entry.date) }
            .fillMaxWidth()
            .height((72 - 8 * 2).dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = entry.date, style = MaterialTheme.typography.bodySmall)
        Text(
            text = entry.title,
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
    }
}