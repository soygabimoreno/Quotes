package soy.gabimoreno.quotes.ui.screens.detail

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import soy.gabimoreno.quotes.data.model.Quote

@Composable
fun QuoteDetailScreen(
    loading: Boolean,
    quote: Quote?,
) {
    if (loading) {
        CircularProgressIndicator()
    }

    quote?.let {
        Text(text = quote.text)
    }
}
