package com.eshevtsov.android.guitar.assistant.feature.login.domain

interface OnLogout {
    suspend operator fun invoke()
}