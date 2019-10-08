package id.niandev.e_katalog.books

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.niandev.e_katalog.R
import id.niandev.e_katalog.model.Books
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter (private val itemBooks: List<Books>, private val mContext: Context, private val listener:(Books)->Unit)
    : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false))
    }

    override fun getItemCount(): Int {
        return itemBooks.size
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.BindItem(itemBooks[position],mContext,listener)
    }


    class BooksViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val judul = view.txt_title_item
        val tahun = view.txt_tahun_item
        val penerbit = view.txt_penerbit_item
        val img_cover = view.img_cover_item
        fun BindItem (books: Books,mContext: Context,listener: (Books) -> Unit){
            judul.text = books.judul
            tahun.text = books.tahun.toString()
            penerbit.text=books.penerbit
            Glide.with(mContext).load(books.gambar).into(img_cover)
            itemView.setOnClickListener {
                listener(books)
            }
        }
    }
}