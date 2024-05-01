package com.example.testeffective.data.sharedpreference

import android.content.Context
import androidx.core.content.edit

class PrefsManager(context: Context) {

    private val prefsToken =
        context.getSharedPreferences(PREFERENCES_NAME_TOKEN, Context.MODE_PRIVATE)


    var cityFrom: String
        get() = this.prefsToken.getString(KEY_CITY_FROM, "") ?: ""
        set(value) {
            this.prefsToken.edit {
                putString(KEY_CITY_FROM, value).apply()
            }
        }

    companion object {
        private const val PREFERENCES_NAME_TOKEN = "storage_token"
        private const val KEY_CITY_FROM = "key_city_from"
    }

}