package com.eshevtsov.android.guitar.assistant.database.data

import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteArtistEntity

object FavouriteArtistTestData : TestData<FavouriteArtistEntity> {
    override fun first() =
        FavouriteArtistEntity(
            userId = UserTestData.first().id,
            id = ArtistTestData.first().id
        )

    override fun second() =
        FavouriteArtistEntity(
            userId = UserTestData.first().id,
            id = ArtistTestData.second().id
        )

    override fun withoutId() =
        FavouriteArtistEntity(
            userId = UserTestData.second().id,
            id = ArtistTestData.first().id
        )

    override fun copy(item: FavouriteArtistEntity, id: Long?) = item.copy(id = id ?: item.id)
}