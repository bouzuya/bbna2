package net.bouzuya.bbna2.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@kotlinx.serialization.Serializable
data class DetailRoute(val entryId: String)

@kotlinx.serialization.Serializable
object ListRoute

class MyAppViewModel : ViewModel() {
    fun sayHello(name: String) {
        println("Hello!!!!! $name")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val viewModel = viewModel<MyAppViewModel>()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ListRoute) {
        composable<DetailRoute> {
            val route = it.toRoute<DetailRoute>()
            DetailScreen(
                entryId = route.entryId,
                onNavigateToList = {
                    navController.navigate(ListRoute)
                }
            )
        }
        composable<ListRoute> {
            ListScreen(onNavigateToDetail = {
                viewModel.sayHello(it)
                navController.navigate(DetailRoute(entryId = it))
            })
        }
    }
}
