package net.bouzuya.bbna2.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
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
                entryId = "2025-02-02",
                onNavigateToList = {
                    navController.navigate("list")
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
