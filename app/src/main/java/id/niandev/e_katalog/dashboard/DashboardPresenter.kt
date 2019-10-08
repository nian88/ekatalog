package id.niandev.e_katalog.dashboard

import android.util.Log
import id.niandev.e_katalog.utils.WebserviceApi
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class DashboardPresenter (private val view: DashboardView,
                       private val webserviceApi: WebserviceApi) {

    fun getBookServer() {
        webserviceApi.getBarang()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { book ->
                    view.moveToListBooks(book)

                },
                { error ->
                    Log.e("Error", error.message)
                }
            )

    }

}