package soy.gabimoreno.quotes.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import soy.gabimoreno.quotes.ui.navigation.NavItem
import soy.gabimoreno.quotes.ui.navigation.navigatePoppingUpToStartDestination

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): AppState = remember(
    scaffoldState,
    navController,
    coroutineScope
) {
    AppState(
        scaffoldState,
        navController,
        coroutineScope
    )
}

class AppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val coroutineScope: CoroutineScope
) {

    companion object {
        val DRAWER_OPTIONS = listOf(
            NavItem.HOME,
            NavItem.SETTINGS
        )
        val BOTTON_NAV_OPTIONS = listOf(
            NavItem.THREE,
            NavItem.FOUR,
            NavItem.FIVE
        )
    }

    val currentRoute: String
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

    val showUpNavigation: Boolean
        @Composable get() = !NavItem.values().map { it.navCommand.route }.contains(currentRoute)

    val showBottomNavigation: Boolean
        @Composable get() = BOTTON_NAV_OPTIONS.any { currentRoute.contains(it.navCommand.feature.route) }

    val drawerSelectedIndex: Int
        @Composable get() = if (showBottomNavigation) {
            DRAWER_OPTIONS.indexOf(NavItem.HOME)
        } else {
            DRAWER_OPTIONS.indexOfFirst { it.navCommand.route == currentRoute }
        }

    fun onUpClick() {
        navController.popBackStack()
    }

    fun onNavItemClick(navItem: NavItem) {
        navController.navigatePoppingUpToStartDestination(navItem.navCommand.route)
    }

    fun onDrawerOptionClick(navItem: NavItem) {
        coroutineScope.launch {
            scaffoldState.drawerState.close()
        }
        onNavItemClick(navItem)
    }

    fun onMenuClick() {
        coroutineScope.launch {
            scaffoldState.drawerState.open()
        }
    }
}
