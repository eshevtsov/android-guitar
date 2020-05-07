package com.eshevtsov.android.guitar.assistant.database.data

import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteAlbumEntity

object FavouriteAlbumTestData : TestData<FavouriteAlbumEntity> {
    override fun first() =
        FavouriteAlbumEntity(
            userId = UserTestData.first().id,
            id = AlbumTestData.first().id
        )

    override fun second() =
        FavouriteAlbumEntity(
            userId = UserTestData.first().id,
            id = AlbumTestData.second().id
        )

    override fun withoutId() =
        FavouriteAlbumEntity(
            userId = UserTestData.second().id,
            id = AlbumTestData.first().id
        )

    override fun copy(item: FavouriteAlbumEntity, id: Long?) = item.copy(id = id ?: item.id)
}