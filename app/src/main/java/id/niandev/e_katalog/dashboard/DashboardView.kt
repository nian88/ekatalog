package id.niandev.e_katalog.dashboard

import id.niandev.e_katalog.model.Books

interface DashboardView {
    fun moveToListBooks(data:List<Books>)
}