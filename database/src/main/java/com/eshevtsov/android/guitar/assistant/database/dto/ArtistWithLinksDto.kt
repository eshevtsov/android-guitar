package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity
import com.eshevtsov.android.guitar.assistant.database.entity.LinkEntity

data class ArtistWithLinksDto(
    @Embedded
    val artist: ArtistEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "artist_foreign_id"
    )
    val links: List<LinkEntity>
)