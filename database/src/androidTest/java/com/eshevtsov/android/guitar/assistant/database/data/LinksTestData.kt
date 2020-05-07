package com.eshevtsov.android.guitar.assistant.database.data

import com.eshevtsov.android.guitar.assistant.database.entity.LinkEntity

object LinksTestData : TestData<LinkEntity> {
    override fun first() =
        LinkEntity(
            value = "firstLinkValue",
            artistForeignId = ArtistTestData.first().id,
            id = 1L
        )

    override fun second() =
        LinkEntity(
            value = "secondLinkValue",
            artistForeignId = ArtistTestData.first().id,
            id = 2L
        )

    override fun withoutId() =
        LinkEntity(
            value = "withoutIdLinkValue",
            artistForeignId = ArtistTestData.first().id
        )

    override fun copy(item: LinkEntity, id: Long?) = item.copy(id = id ?: item.id)
}