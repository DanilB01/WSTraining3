package ru.tsu.wstraining3

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(val context: Context) {
    private val PREFS_NAME = "MyNovel"
    val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveString(KEY_NAME: String, value: String) {
        sharedPref
            .edit()
            .putString(KEY_NAME, value)
            .apply()
    }

    fun getString(KEY_NAME: String): String? {

        return sharedPref.getString(KEY_NAME, "")
    }

    fun clearSharedPreference() {
        sharedPref
            .edit()
            .clear()
            .apply()
    }

    fun removeValue(KEY_NAME: String) {
        sharedPref
            .edit()
            .remove(KEY_NAME)
            .apply()
    }
}
