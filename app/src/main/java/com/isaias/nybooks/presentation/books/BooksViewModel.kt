package com.isaias.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isaias.nybooks.data.model.Book

class BooksViewModel : ViewModel(){
    val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(){
        booksLiveData.value = createdMockedBooks()
    }

    fun createdMockedBooks(): List<Book>{
        return listOf(
            Book("Livro 1", "Autor 1"),
            Book("Livro 2", "Autor 2"),
            Book("Livro 3", "Autor 3")
        )
    }
}