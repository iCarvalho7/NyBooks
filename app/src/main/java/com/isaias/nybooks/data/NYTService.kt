package com.isaias.nybooks.data

import com.isaias.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTService {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "4PYCdrfcg3g5Hck7IEgZ12JS7JgbLQxT",
        @Query("list") list: String  = "hardcover-fiction"
    ): Call<BookBodyResponse>
}