package soy.gabimoreno.quotes.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import soy.gabimoreno.quotes.ui.theme.QuotesTheme

@Composable
fun QuotesUI(appState: AppState = rememberAppState()) {
    QuotesScreen {
        Scaffold(
            topBar = {

            },
            bottomBar = {

            },
            drawerContent = {

            },
            scaffoldState = appState.scaffoldState
        ) {

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
