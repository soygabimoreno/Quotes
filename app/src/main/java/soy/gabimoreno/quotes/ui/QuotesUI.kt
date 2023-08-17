package soy.gabimoreno.quotes.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import soy.gabimoreno.quotes.ui.navigation.DrawerContent
import soy.gabimoreno.quotes.ui.navigation.Navigation
import soy.gabimoreno.quotes.ui.theme.QuotesTheme

@ExperimentalFoundationApi
@Composable
fun QuotesUI(appState: AppState = rememberAppState()) {
    QuotesScreen {
        Scaffold(
            topBar = {

            },
            bottomBar = {
                if (appState.showUpNavigation) {
                    AppBottomNavigation(
                        bottomNavOptions = AppState.BOTTON_NAV_OPTIONS,
                        currentRoute = appState.currentRoute,
                        onNavItemClick = { appState.onNavItemClick(it) }
                    )
                }
            },
            drawerContent = {
                DrawerContent(
                    drawerOptions = AppState.DRAWER_OPTIONS,
                    selectedIndex = appState.drawerSelectedIndex,
                    onOptionClick = { appState.onDrawerOptionClick(it) }
                )
            },
            scaffoldState = appState.scaffoldState
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(appState.navController)
            }
        }
    }
}

@Composable
fun QuotesScreen(content: @Composable () -> Unit) {
    QuotesTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}
