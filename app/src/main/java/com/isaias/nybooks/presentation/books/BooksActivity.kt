package com.isaias.nybooks.presentation.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.isaias.nybooks.data.model.Book
import com.isaias.nybooks.ui.activity.R
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        mainToolbar.title = getString(R.string.books_toolbar_title)
        setSupportActionBar(mainToolbar)

        val viewModel: BooksViewModel = ViewModelProvider(this).get(BooksViewModel::class.java)
        viewModel.booksLiveData.observe(this, Observer {
            it?.let {books ->
                with(recycler_books){
                    layoutManager = LinearLayoutManager(this@BooksActivity,RecyclerView.VERTICAL, false)
                    adapter = BooksRecyclerViewAdapter(books)
                }
            }
        })
        viewModel.getBooks()
    }
}
