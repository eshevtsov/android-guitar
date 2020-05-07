package com.eshevtsov.android.guitar.assistant.database.data

import com.eshevtsov.android.guitar.assistant.database.entity.UserArtistEntity

object UserArtistTestData : TestData<UserArtistEntity> {
    override fun first() =
        UserArtistEntity(
            userId = UserTestData.first().id,
            id = ArtistTestData.first().id
        )

    override fun second() =
        UserArtistEntity(
            userId = UserTestData.first().id,
            id = ArtistTestData.second().id
        )

    override fun withoutId() =
        UserArtistEntity(
            userId = UserTestData.second().id,
            id = ArtistTestData.first().id
        )

    override fun copy(item: UserArtistEntity, id: Long?) = item.copy(id = id ?: item.id)
}