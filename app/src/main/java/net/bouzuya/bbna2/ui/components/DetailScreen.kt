package net.bouzuya.bbna2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(entryId: String, onNavigateToList: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(64.dp).fillMaxWidth())
        Text("detail screen ${entryId}!", modifier = Modifier.clickable {
            onNavigateToList()
        }.fillMaxWidth())
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen("entryId1") { }
}