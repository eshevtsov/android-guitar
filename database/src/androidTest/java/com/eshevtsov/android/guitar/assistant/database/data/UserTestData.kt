package com.eshevtsov.android.guitar.assistant.database.data

import com.eshevtsov.android.guitar.assistant.database.entity.UserEntity

object UserTestData : TestData<UserEntity> {
    override fun first() =
        UserEntity(
            googleTokenId = "firstUserGoogleTokenId",
            id = 1L
        )

    override fun second() =
        UserEntity(
            googleTokenId = "secondUserGoogleTokenId",
            id = 2L
        )

    override fun withoutId() =
        UserEntity(
            googleTokenId = "withoutIdUserGoogleTokenId"
        )

    override fun copy(item: UserEntity, id: Long?) = item.copy(id = id ?: item.id)
}