package com.whatrushka.devrush4ichallenge.quotes.data

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whatrushka.devrush4ichallenge.models.Quote
import com.whatrushka.devrush4ichallenge.network.ApiRepo
import com.whatrushka.devrush4ichallenge.storage.data.FilterService
import com.whatrushka.devrush4ichallenge.storage.models.Filter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuotesViewModel(
    private val apiRepo: ApiRepo,
    private val filterService: FilterService
) : ViewModel(), QuotesService {
    private val _quotes = mutableStateOf(listOf<Quote>())
    fun quotes(): MutableState<List<Quote>> = _quotes


    fun getCategories() = filterService.categories
    override fun fetchFilter() = filterService.fetchFilter()
    override fun configureFilter(block: (Filter) -> Unit) {
        filterService.setFilter(block)
        clearQuotes()
        fetchQuotes()
    }

    private fun clearQuotes() {
        _quotes.value = listOf()
    }

    override fun fetchQuotes(count: Int) {
        viewModelScope.launch {
            for (i in 0 until count) {
                Log.d("m", _quotes.value.size.toString())
//                delay(100)
                _quotes.value = _quotes.value.toMutableList().also {
                    it.addAll(apiRepo.fetchQuotes(filterService.fetchFilter().category))
                }
            }
        }
    }
}