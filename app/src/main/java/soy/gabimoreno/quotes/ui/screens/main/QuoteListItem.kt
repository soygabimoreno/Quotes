package soy.gabimoreno.quotes.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import soy.gabimoreno.quotes.data.model.Quote

@Composable
fun QuoteListItem(
    quote: Quote,
    modifier: Modifier,
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier.padding(
                8.dp,
                16.dp
            )
        ) {
            Text(
                text = quote.text,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2
            )
        }
    }
}
