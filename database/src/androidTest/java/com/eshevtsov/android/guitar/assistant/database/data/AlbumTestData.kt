package com.eshevtsov.android.guitar.assistant.database.data

import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity

object AlbumTestData : TestData<AlbumEntity> {
    override fun first() =
        AlbumEntity(
            name = "firstAlbumName",
            artistForeignId = ArtistTestData.first().id,
            id = 1L
        )

    override fun second() =
        AlbumEntity(
            name = "secondAlbumName",
            artistForeignId = ArtistTestData.first().id,
            id = 2L
        )

    override fun withoutId() =
        AlbumEntity(
            name = "withoutIdAlbumName",
            artistForeignId = ArtistTestData.first().id
        )

    override fun copy(item: AlbumEntity, id: Long?) = item.copy(id = id ?: item.id)
}