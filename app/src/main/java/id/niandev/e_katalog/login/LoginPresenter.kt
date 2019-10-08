package id.niandev.e_katalog.login

import android.util.Log
import id.niandev.e_katalog.utils.WebserviceApi
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class LoginPresenter (private val view: LoginView,
                      private val webserviceApi: WebserviceApi
){
    fun doLoginServer(username:String, password:String) {
        webserviceApi.doLogin(username,password)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { member ->
                    view.moveToDashboard(member)

                },
                { error ->
                    Log.e("Error", error.message)
                }
            )

    }
}