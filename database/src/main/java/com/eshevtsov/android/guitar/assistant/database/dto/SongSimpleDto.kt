package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.ColumnInfo
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity

data class SongSimpleDto(
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "album_foreign_id")
    val albumForeignId: Long,

    @Relation(
        parentColumn = "album_foreign_id",
        entityColumn = "id",
        entity = AlbumEntity::class
    )
    val albumSimpleDto: AlbumSimpleDto
)