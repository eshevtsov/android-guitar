package com.eshevtsov.android.guitar.assistant.feature.login.domain

interface UserRepository {
    suspend fun create(googleTokenId: String, displayTitle: String? = null): UserModel
    suspend fun get(googleTokenId: String): UserModel?
    suspend fun get(id: Long): UserModel?
}