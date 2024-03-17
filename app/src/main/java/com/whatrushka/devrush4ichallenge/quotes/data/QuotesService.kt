package com.whatrushka.devrush4ichallenge.quotes.data

import com.whatrushka.devrush4ichallenge.storage.models.Filter

interface QuotesService {
    fun fetchFilter(): Filter
    fun configureFilter(block: (Filter) -> Unit)

    fun fetchQuotes(count: Int = 10)
}