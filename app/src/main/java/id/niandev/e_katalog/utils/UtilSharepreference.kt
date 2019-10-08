package id.niandev.e_katalog.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class UtilSharepreference {
    companion object {
        val PREF_NAME = "ekatalog"
        val ISLOGIN = "islogin"
        val ISNAMA = "isnama"
        val ISJEKEL = "isjekel"
        val ISHP = "ishp"
    }
    fun setString(context: Context, key: String, text: String) {
        val settings: SharedPreferences
        val editor: Editor
        settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = settings.edit()
        editor.putString(key, text)
        editor.apply()
    }
    fun setBoolean(context: Context, key: String, text: Boolean) {
        val settings: SharedPreferences
        val editor: Editor
        settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = settings.edit()
        editor.putBoolean(key, text)
        editor.apply()
    }
    fun setInt(context: Context, key: String, text: Int) {
        val settings: SharedPreferences
        val editor: Editor
        settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = settings.edit()
        editor.putInt(key, text)
        editor.apply()
    }

    fun getString(context: Context, key: String): String? {
        val settings: SharedPreferences
        val text: String?
        settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        text = settings.getString(key, null)
        return text
    }
    fun getBoolean(context: Context, key: String): Boolean {
        val settings: SharedPreferences
        val text: Boolean?
        settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        text = settings.getBoolean(key, false)
        return text
    }
    fun getInteger(context: Context, key: String): Int? {
        val settings: SharedPreferences
        val text: Int?
        settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        text = settings.getInt(key, 0)
        return text
    }

    fun clearSharedPreference(context: Context) {
        val settings: SharedPreferences
        val editor: Editor
        settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = settings.edit()
        editor.clear()
        editor.apply()
    }

    fun removeValue(context: Context, key: String) {
        val settings: SharedPreferences
        val editor: Editor

        settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = settings.edit()

        editor.remove(key)
        editor.apply()
    }
}