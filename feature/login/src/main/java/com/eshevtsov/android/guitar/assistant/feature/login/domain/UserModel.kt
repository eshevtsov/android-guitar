package com.eshevtsov.android.guitar.assistant.feature.login.domain

data class UserModel(
    val id: Long,
    val googleTokenId: String,
    val displayTitle: String? = null
)