package com.whatrushka.devrush4ichallenge.network

import android.util.Log
import com.whatrushka.devrush4ichallenge.models.Quote
import com.whatrushka.devrush4ichallenge.static.categories
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.request
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.jsonObject

class ApiRepoImpl(private val client: HttpClient) : ApiRepo {
    override fun fetchCategories(): List<String> {
        return categories
    }

    override suspend fun fetchQuotes(category: String): List<Quote> =
        client.get("https://api.api-ninjas.com/v1/quotes") {
            url {
                parameters.let {
                    it.append("x-api-key", "5oMXra9IkXmkVyRWTemxay8QWyKerpeGRUMUyZin")
                    it.append("category", category)
                }
            }
        }.body<List<Quote>>()
}