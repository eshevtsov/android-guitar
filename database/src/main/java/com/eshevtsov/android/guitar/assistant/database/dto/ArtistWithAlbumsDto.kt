package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.ColumnInfo
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity

data class ArtistWithAlbumsDto(
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @Relation(
        parentColumn = "id",
        entityColumn = "artist_foreign_id",
        entity = AlbumEntity::class
    )
    val albums: List<AlbumWithSongsDto>
)