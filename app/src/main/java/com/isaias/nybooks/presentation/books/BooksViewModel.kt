package com.isaias.nybooks.presentation.books

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isaias.nybooks.data.APIService
import com.isaias.nybooks.data.model.Book
import com.isaias.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {
    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        APIService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {

            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                when {
                    response.isSuccessful ->{
                        val books: MutableList<Book> = mutableListOf()
                        response.body()?.let { bookBodyResponse ->

                            for (result in bookBodyResponse.bookResults) {
                                val book = Book(
                                    title = result.bookDetailResponses[0].title,
                                    author = result.bookDetailResponses[0].author
                                )
                                books.add(book)
                            }
                        }
                        booksLiveData.value = books
                    }
                }
            }
            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {}
        })
    }
}