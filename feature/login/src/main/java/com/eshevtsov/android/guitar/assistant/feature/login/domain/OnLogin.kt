package com.eshevtsov.android.guitar.assistant.feature.login.domain

interface OnLogin {
    suspend operator fun invoke(user: UserModel)
}