package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity
import com.eshevtsov.android.guitar.assistant.database.entity.SongEntity

data class SongDetailsDto(
    @Embedded
    val song: SongEntity,

    @Relation(
        parentColumn = "album_foreign_id",
        entityColumn = "id",
        entity = AlbumEntity::class
    )
    val albumWithArtist: AlbumWithArtistDto
)