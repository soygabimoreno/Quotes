package soy.gabimoreno.quotes.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import soy.gabimoreno.quotes.data.model.Quote
import soy.gabimoreno.quotes.data.repository.QuotesRepository

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(quotes = QuotesRepository.get())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val quotes: List<Quote> = emptyList(),
    )
}
