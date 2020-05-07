package com.eshevtsov.android.guitar.assistant.database.data

import com.eshevtsov.android.guitar.assistant.database.entity.UserEntity

object UserTestData : TestData<UserEntity> {
    override fun first() =
        UserEntity(
            googleTokenHash = "firstUserGoogleTokenHash",
            id = 1L
        )

    override fun second() =
        UserEntity(
            googleTokenHash = "secondUserGoogleTokenHash",
            id = 2L
        )

    override fun withoutId() =
        UserEntity(
            googleTokenHash = "withoutIdUserGoogleTokenHash"
        )

    override fun copy(item: UserEntity, id: Long?) = item.copy(id = id ?: item.id)
}