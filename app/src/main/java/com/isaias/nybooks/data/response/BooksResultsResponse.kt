package com.isaias.nybooks.data.response

import com.squareup.moshi.Json

data class BooksResultsResponse (
    @Json(name = "book_details")
    val bookDetais: List<BookDetailsResponse>
)