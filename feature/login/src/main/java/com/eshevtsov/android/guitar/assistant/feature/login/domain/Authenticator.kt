package com.eshevtsov.android.guitar.assistant.feature.login.domain

interface Authenticator {
    val user: UserModel
        @Throws(NoLoggedUserException::class) get

    fun init(user: UserModel)
    fun release()
}