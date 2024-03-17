package com.whatrushka.devrush4ichallenge.storage.data

import com.whatrushka.devrush4ichallenge.storage.models.Filter

interface FilterService {
    val categories: List<String>

    fun fetchFilter(): Filter

    fun setFilter(block: (Filter) -> Unit)
}