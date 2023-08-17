package soy.gabimoreno.quotes.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import soy.gabimoreno.quotes.ui.screens.detail.DetailScreen
import soy.gabimoreno.quotes.ui.screens.main.MainScreen

@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Feature.QUOTES.route
    ) {
        quotesNav(navController)
    }
}

@ExperimentalFoundationApi
fun NavGraphBuilder.quotesNav(navController: NavHostController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.QUOTES).route,
        route = Feature.QUOTES.route
    ) {
        composable(NavCommand.ContentType(Feature.QUOTES)) {
            MainScreen(
                onClick = { quote ->
                    navController.navigate(
                        NavCommand.ContentTypeDetail(Feature.QUOTES).createRoute(quote.id)
                    )
                }
            )
        }
        composable(NavCommand.ContentTypeDetail(Feature.TWO)) {
            DetailScreen()
        }
    }
}

private fun NavGraphBuilder.composable(
    navCommand: NavCommand,
    content: @Composable (NavBackStackEntry) -> Unit,
) {
    composable(
        route = navCommand.route,
        arguments = navCommand.args
    ) {
        content(it)
    }
}
