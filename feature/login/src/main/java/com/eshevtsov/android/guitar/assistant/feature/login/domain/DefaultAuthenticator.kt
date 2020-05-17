package com.eshevtsov.android.guitar.assistant.feature.login.domain

class DefaultAuthenticator : Authenticator {

    private var loggedUser: UserModel? = null

    override val user: UserModel
        get() = loggedUser ?: throw NoLoggedUserException()

    override fun init(user: UserModel) {
        loggedUser = user
    }

    override fun release() {
        loggedUser = null
    }
}