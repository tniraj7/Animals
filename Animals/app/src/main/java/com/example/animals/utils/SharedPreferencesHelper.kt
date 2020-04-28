package com.example.animals.utils

import android.content.Context
import android.preference.PreferenceManager

class SharedPreferencesHelper(context: Context) {

    private val PREF_API_KEY  = "API_KEY"

    private val prefs = PreferenceManager.getDefaultSharedPreferences(context.applicationContext)

    fun saveAPIKey(key: String?) {

        prefs.edit().putString(PREF_API_KEY, key).apply()
    }

    fun getAPIKey() = prefs.getString(PREF_API_KEY, null)
}