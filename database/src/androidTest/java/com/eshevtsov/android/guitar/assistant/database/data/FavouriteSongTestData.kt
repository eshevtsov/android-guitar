package com.eshevtsov.android.guitar.assistant.database.data

import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteSongEntity

object FavouriteSongTestData : TestData<FavouriteSongEntity> {
    override fun first() =
        FavouriteSongEntity(
            userId = UserTestData.first().id,
            id = SongTestData.first().id
        )

    override fun second() =
        FavouriteSongEntity(
            userId = UserTestData.first().id,
            id = SongTestData.second().id
        )

    override fun withoutId() =
        FavouriteSongEntity(
            userId = UserTestData.second().id,
            id = SongTestData.first().id
        )

    override fun copy(item: FavouriteSongEntity, id: Long?) = item.copy(id = id ?: item.id)
}