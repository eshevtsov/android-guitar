package com.eshevtsov.android.guitar.assistant.database.data

import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity

object ArtistTestData : TestData<ArtistEntity> {
    override fun first() =
        ArtistEntity(
            name = "firstArtistName",
            id = 1L
        )

    override fun second() =
        ArtistEntity(
            name = "secondArtistName",
            id = 2L
        )

    override fun withoutId() =
        ArtistEntity(
            name = "withoutIdArtistName"
        )

    override fun copy(item: ArtistEntity, id: Long?) = item.copy(id = id ?: item.id)
}