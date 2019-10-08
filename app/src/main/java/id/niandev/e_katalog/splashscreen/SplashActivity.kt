package id.niandev.e_katalog.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import id.niandev.e_katalog.R
import id.niandev.e_katalog.dashboard.DashboardActivity
import id.niandev.e_katalog.login.LoginActivity
import id.niandev.e_katalog.utils.UtilSharepreference
import id.niandev.e_katalog.utils.UtilSharepreference.Companion.ISLOGIN
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {
    private val TIMEOUT:Long=3000 // 3 sec
    val utilSharepreference= UtilSharepreference()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AppCompat_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Glide.with(this).load(getString(R.string.logo)).into(img_splashscreen)

        Handler().postDelayed({
            checkIslogin()
        }, TIMEOUT)
    }
    private fun checkIslogin(){
        if(utilSharepreference.getBoolean(this,ISLOGIN)){
            startActivity<DashboardActivity>()
        }else{
            startActivity<LoginActivity>()
        }
        finish()
    }
}
