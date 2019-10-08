package id.niandev.e_katalog.utils

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun getService(): Retrofit {
    val gson = GsonBuilder().create()
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .baseUrl("http://unp.niandev.com/")
        .build()
    return retrofit
}
fun isNetworkAvailable(contexts: Context): Boolean {
    val connectivityManager = contexts.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

