package id.niandev.e_katalog.registrasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.niandev.e_katalog.R
import kotlinx.android.synthetic.main.activity_registrasi.*

class RegistrasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AppCompat_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)
        Glide.with(this).load(getString(R.string.imguser)).into(img_registrasi)

    }
}
