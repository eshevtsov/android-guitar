package com.eshevtsov.android.guitar.assistant.database.data

import com.eshevtsov.android.guitar.assistant.database.entity.SongEntity

object SongTestData : TestData<SongEntity> {
    override fun first() =
        SongEntity(
            name = "firstSongName",
            albumForeignId = AlbumTestData.first().id,
            id = 1L
        )

    override fun second() =
        SongEntity(
            name = "secondSongName",
            albumForeignId = AlbumTestData.first().id,
            id = 2L
        )

    override fun withoutId() =
        SongEntity(
            name = "withoutIdSongName",
            albumForeignId = AlbumTestData.first().id
        )

    override fun copy(item: SongEntity, id: Long?) = item.copy(id = id ?: item.id)
}