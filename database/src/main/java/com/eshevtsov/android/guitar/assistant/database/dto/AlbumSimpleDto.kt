package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.ColumnInfo
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity

data class AlbumSimpleDto(
    @ColumnInfo(name = "cover")
    val coverUri: String? = null,

    @ColumnInfo(name = "artist_foreign_id")
    val artistForeignId: Long,

    @Relation(
        parentColumn = "artist_foreign_id",
        entityColumn = "id",
        entity = ArtistEntity::class
    )
    val artistNameDto: ArtistNameDto
)