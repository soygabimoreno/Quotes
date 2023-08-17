package soy.gabimoreno.quotes.ui.screens.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@ExperimentalFoundationApi
@Composable
fun DetailScreen(
    viewModel: DetailViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()
    QuoteDetailScreen(
        loading = state.loading,
        quote = state.quote
    )
}
