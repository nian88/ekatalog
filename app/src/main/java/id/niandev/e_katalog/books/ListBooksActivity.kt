package id.niandev.e_katalog.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.niandev.e_katalog.R
import id.niandev.e_katalog.model.Books
import kotlinx.android.synthetic.main.activity_list_books.*
import org.jetbrains.anko.startActivity

class ListBooksActivity : AppCompatActivity() {
    private  var dataBooks: MutableList<Books> = mutableListOf()
    private lateinit var adapter: BooksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_books)

        supportActionBar?.title = "List Books"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        rv_listbooks.setHasFixedSize(true)
        rv_listbooks.layoutManager= LinearLayoutManager(this)
        rv_listbooks.addItemDecoration(DividerItemDecoration(this,1))
        adapter = BooksAdapter(dataBooks,this){
            startActivity<DetailBookActivity>(
                "dataBook" to it
            )
        }
        loadData()
        rv_listbooks.adapter = adapter
    }

    private fun loadData() {
        val books=intent.getParcelableArrayListExtra<Books>("dataBook")
        dataBooks.clear()
        dataBooks.addAll(books)
        adapter.notifyDataSetChanged()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
    }

}
