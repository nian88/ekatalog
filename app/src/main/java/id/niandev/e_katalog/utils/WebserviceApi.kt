package id.niandev.e_katalog.utils

import id.niandev.e_katalog.model.Books
import id.niandev.e_katalog.model.Member
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Single

interface WebserviceApi {
    @POST("buku.json")
    fun getBarang(): Single<List<Books>>

    @POST("member.json")
    fun doLogin(@Query("username") username:String, @Query("password") password:String): Single<Member>
}