package com.isaias.nybooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isaias.nybooks.data.model.Book
import com.isaias.nybooks.ui.activity.R
import kotlinx.android.synthetic.main.item_book.view.*

class BooksRecyclerViewAdapter(val books: List<Book>) : RecyclerView.Adapter<BooksRecyclerViewAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent,false)
        return BooksViewHolder(itemView)
    }

    override fun getItemCount() = books.count()

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])
    }

    class BooksViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val title = itemView.item_title
        private val author = itemView.item_author

        fun bindView(book: Book){
            title.text = book.title
            author.text = book.author
        }
    }
}