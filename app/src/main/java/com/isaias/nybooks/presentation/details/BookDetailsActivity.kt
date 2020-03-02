package com.isaias.nybooks.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isaias.nybooks.ui.activity.R
import kotlinx.android.synthetic.main.activity_book_details.*

class BookDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        booksDetaisTitle_tv.text = intent.getStringExtra(EXTRA_TITLE)
        booksDetaisDescription_tv.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }
    companion object{
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getSartIntent(context: Context, title: String, description: String ): Intent{
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}
