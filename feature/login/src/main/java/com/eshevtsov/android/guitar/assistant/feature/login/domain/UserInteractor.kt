package com.eshevtsov.android.guitar.assistant.feature.login.domain

interface UserInteractor {
    suspend fun loginWithGoogle(googleTokenId: String, displayTitle: String? = null)
    suspend fun logout()
    suspend fun trySilentLogin(): Boolean
}