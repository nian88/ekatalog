package id.niandev.e_katalog.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import id.niandev.e_katalog.R
import id.niandev.e_katalog.dashboard.DashboardActivity
import id.niandev.e_katalog.model.Member
import id.niandev.e_katalog.registrasi.RegistrasiActivity
import id.niandev.e_katalog.utils.UtilSharepreference
import id.niandev.e_katalog.utils.WebserviceApi
import id.niandev.e_katalog.utils.getService
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity(),LoginView {

    val utilSharepreference= UtilSharepreference()

    private lateinit var api: WebserviceApi
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AppCompat_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Glide.with(this).load(getString(R.string.imguser)).into(img_login)
        txt_createaccount.text = HtmlCompat.fromHtml(getString(R.string.buat_akun), HtmlCompat.FROM_HTML_MODE_LEGACY)

        api = getService().create(WebserviceApi::class.java)
        presenter = LoginPresenter(this, api)

        txt_createaccount.setOnClickListener {
            startActivity<RegistrasiActivity>()
        }
        btn_login.setOnClickListener {
            presenter.doLoginServer(ed_username_login.text.toString(),ed_password_login.text.toString())
        }
    }

    override fun invalidLogin(msg: String) {
        toast(msg)
    }

    override fun moveToDashboard(data: Member) {
        utilSharepreference.setBoolean(this,"islogin",true)
        utilSharepreference.setString(this,"isnama",data.nama)
        utilSharepreference.setInt(this,"isjekel",data.jekel)
        utilSharepreference.setString(this,"ishp",data.hp)
        startActivity<DashboardActivity>()
        finish()
    }
}
