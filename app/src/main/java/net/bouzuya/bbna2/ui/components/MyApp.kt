package net.bouzuya.bbna2.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "list") {
        composable("detail") {
            DetailScreen(
                entryId = "entryId1",
                onNavigateToList = {
                    navController.popBackStack()
                }
            )
        }
        composable("list") {
            ListScreen(onNavigateToDetail = {
                navController.navigate("detail")
            })
        }
    }
}