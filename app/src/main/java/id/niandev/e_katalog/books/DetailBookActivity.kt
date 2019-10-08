package id.niandev.e_katalog.books

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.niandev.e_katalog.R
import id.niandev.e_katalog.model.Books
import kotlinx.android.synthetic.main.activity_detail_book.*
import kotlinx.android.synthetic.main.content_detail_book.*

class DetailBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_book)
        setSupportActionBar(toolbar)

        val book = intent.getParcelableExtra<Books>("dataBook")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        supportActionBar?.title = book.judul
        txt_sinopsis.text=book.sinopsis
        Glide.with(this).load(book.gambar).into(img_cover_book)
        btn_favorite.setOnClickListener { view ->
            Snackbar.make(view, "Buku Telah Difavoritkan", Snackbar.LENGTH_LONG).show()
        }
    }
}