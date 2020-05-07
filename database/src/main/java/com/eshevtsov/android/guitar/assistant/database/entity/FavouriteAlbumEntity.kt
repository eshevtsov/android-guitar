package com.eshevtsov.android.guitar.assistant.database.entity

import androidx.room.*

@Entity(
    tableName = "favourite_album",
    primaryKeys = ["user_id", "id"]
)
data class FavouriteAlbumEntity(
    @ColumnInfo(name = "user_id")
    val userId: Long,

    @ColumnInfo(name = "id")
    override val id: Long
) : Unique