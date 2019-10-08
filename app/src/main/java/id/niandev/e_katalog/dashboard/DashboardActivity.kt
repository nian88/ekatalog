package id.niandev.e_katalog.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.niandev.e_katalog.R
import id.niandev.e_katalog.books.ListBooksActivity
import id.niandev.e_katalog.model.Books
import id.niandev.e_katalog.utils.UtilSharepreference
import id.niandev.e_katalog.utils.WebserviceApi
import id.niandev.e_katalog.utils.getService
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.jetbrains.anko.startActivity

class DashboardActivity : AppCompatActivity(),DashboardView {
    private lateinit var api: WebserviceApi
    private lateinit var presenter: DashboardPresenter

    val utilSharepreference= UtilSharepreference()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        Glide.with(this).load(getString(R.string.imguser)).into(img_dashboard)
        api = getService().create(WebserviceApi::class.java)
        presenter = DashboardPresenter(this, api)

        txt_dashboard_nama.text=utilSharepreference.getString(this,"isnama")
        txt_dashboard_hp.text=utilSharepreference.getString(this,"ishp")
        val jekel = resources.getStringArray(R.array.arr_jekel).get(utilSharepreference.getInteger(this,"isjekel")!!.toInt())
        txt_dashboard_jekel.text=jekel

        img_books.setOnClickListener {
            loadBooksFormServer()
        }
        img_books_favorite.setOnClickListener {
            loadBooksFromLocal()
        }
    }

    private fun loadBooksFromLocal() {
        presenter.getBookServer()
    }

    private fun loadBooksFormServer() {
        presenter.getBookServer()
    }
    override fun moveToListBooks(data: List<Books>) {
        startActivity<ListBooksActivity>(
            "dataBook" to data
        )
    }
}
