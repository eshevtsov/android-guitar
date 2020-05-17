package com.eshevtsov.android.guitar.assistant.feature.login.data

import android.content.SharedPreferences
import com.eshevtsov.android.guitar.assistant.core.feature.preference.SharedPreferencesHolder
import com.eshevtsov.android.guitar.assistant.core.feature.preference.preference
import com.eshevtsov.android.guitar.assistant.feature.login.domain.LoggedUserPreferences

class DefaultLoggedUserPreferences(
    override val preferences: SharedPreferences
) : LoggedUserPreferences, SharedPreferencesHolder {

    override var loggedUserId: Long by preference(LOGGED_USER_ID_KEY)
}

private const val LOGGED_USER_ID_KEY = "logger_user_id_key"