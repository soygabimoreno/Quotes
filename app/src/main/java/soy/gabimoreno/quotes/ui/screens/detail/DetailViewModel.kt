package soy.gabimoreno.quotes.ui.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import soy.gabimoreno.quotes.data.model.Quote
import soy.gabimoreno.quotes.data.repository.QuotesRepository
import soy.gabimoreno.quotes.ui.navigation.NavArg

class DetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val id = savedStateHandle.get<Long>(NavArg.ItemId.key) ?: 1

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(quote = QuotesRepository.find(id))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val quote: Quote? = null,
    )
}
