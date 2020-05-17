package com.eshevtsov.android.guitar.assistant.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class AppPreferences(
    context: Context
) {
    val preferencesValue: SharedPreferences =
        context.getSharedPreferences(APP_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun clear() {
        preferencesValue.edit { clear() }
    }
}

private const val APP_SHARED_PREFERENCES_NAME = "app_shared_preferences_name"