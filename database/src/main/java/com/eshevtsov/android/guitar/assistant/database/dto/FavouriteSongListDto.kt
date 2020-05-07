package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.ColumnInfo
import androidx.room.Junction
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteSongEntity
import com.eshevtsov.android.guitar.assistant.database.entity.SongEntity

data class FavouriteSongListDto(
    @ColumnInfo(name = "user_id")
    val id: Long,

    @Relation(
        parentColumn = "user_id",
        entityColumn = "id",
        associateBy = Junction(FavouriteSongEntity::class),
        entity = SongEntity::class
    )
    val songList: List<SongSimpleDto>
)