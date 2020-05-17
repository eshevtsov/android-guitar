package com.eshevtsov.android.guitar.assistant.feature.login.domain

class SaveUserToPreferencesOnLogin(
    private val loggedUserPreferences: LoggedUserPreferences
) : OnLogin {
    override suspend fun invoke(user: UserModel) {
        loggedUserPreferences.loggedUserId = user.id
    }
}