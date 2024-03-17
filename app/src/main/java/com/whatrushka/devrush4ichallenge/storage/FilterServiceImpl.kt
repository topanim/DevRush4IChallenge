package com.whatrushka.devrush4ichallenge.storage

import com.whatrushka.devrush4ichallenge.storage.data.FilterService
import com.whatrushka.devrush4ichallenge.storage.models.Filter

class FilterServiceImpl(private val filter: Filter, override val categories: List<String>) : FilterService {

    override fun fetchFilter(): Filter {
        return filter
    }

    override fun setFilter(block: (Filter) -> Unit) {
        block(filter)
    }

}