package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.ColumnInfo
import androidx.room.Junction
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity
import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteAlbumEntity

data class FavouriteAlbumListDto(
    @ColumnInfo(name = "user_id")
    val id: Long,

    @Relation(
        parentColumn = "user_id",
        entityColumn = "id",
        associateBy = Junction(FavouriteAlbumEntity::class)
    )
    val albumList: List<AlbumEntity>
)