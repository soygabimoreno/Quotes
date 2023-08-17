package soy.gabimoreno.quotes.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import soy.gabimoreno.quotes.data.model.Quote

@ExperimentalFoundationApi
@Composable
fun MainScreen(
    onClick: (Quote) -> Unit,
    viewModel: MainViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()
    ItemListScreen(
        loading = state.loading,
        items = state.quotes,
        onClick = onClick,
    )
}
