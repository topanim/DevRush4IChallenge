package com.whatrushka.devrush4ichallenge.network

import com.whatrushka.devrush4ichallenge.models.Quote

interface ApiRepo {
    fun fetchCategories(): List<String>

    suspend fun fetchQuotes(category: String = ""): List<Quote>
}