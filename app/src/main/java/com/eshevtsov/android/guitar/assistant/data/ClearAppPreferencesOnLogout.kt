package com.eshevtsov.android.guitar.assistant.data

import com.eshevtsov.android.guitar.assistant.feature.login.domain.OnLogout

class ClearAppPreferencesOnLogout(
    private val appPreferences: AppPreferences
) : OnLogout {
    override suspend fun invoke() {
        appPreferences.clear()
    }
}