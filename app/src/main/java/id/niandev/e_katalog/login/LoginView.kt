package id.niandev.e_katalog.login

import id.niandev.e_katalog.model.Member

interface LoginView {
    fun invalidLogin (msg:String)
    fun moveToDashboard(data:Member)
}