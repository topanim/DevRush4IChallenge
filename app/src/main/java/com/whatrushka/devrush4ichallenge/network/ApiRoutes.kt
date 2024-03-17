package com.whatrushka.devrush4ichallenge.network

sealed class ApiRoutes(var path: String) {
    data object SCHEME : ApiRoutes("https://")
    data object DOMAIN : ApiRoutes("api.api-ninjas.com")
    data object Quotes : ApiRoutes("v1/quotes")
}