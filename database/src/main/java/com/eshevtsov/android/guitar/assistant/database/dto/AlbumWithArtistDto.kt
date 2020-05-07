package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity
import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity

data class AlbumWithArtistDto(
    @Embedded
    val album: AlbumEntity,

    @Relation(
        parentColumn = "artist_foreign_id",
        entityColumn = "id"
    )
    val artist: ArtistEntity
)