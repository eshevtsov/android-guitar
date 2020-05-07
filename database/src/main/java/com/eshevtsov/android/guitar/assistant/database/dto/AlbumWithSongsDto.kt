package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.ColumnInfo
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.SongEntity

data class AlbumWithSongsDto(
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "cover")
    val coverUri: String? = null,

    @Relation(
        parentColumn = "id",
        entityColumn = "album_foreign_id",
        entity = SongEntity::class
    )
    val songs: List<SongNameDto>
)