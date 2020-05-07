package com.eshevtsov.android.guitar.assistant.database.entity

import androidx.room.*

@Entity(
    tableName = "favourite_song",
    primaryKeys = ["user_id", "id"]
)
data class FavouriteSongEntity(
    @ColumnInfo(name = "user_id")
    val userId: Long,

    @ColumnInfo(name = "id")
    override val id: Long
) : Unique