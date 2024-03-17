package com.whatrushka.devrush4ichallenge.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    @SerialName("quote")
    val content: String,
    val author: String,
    val category: String
)
