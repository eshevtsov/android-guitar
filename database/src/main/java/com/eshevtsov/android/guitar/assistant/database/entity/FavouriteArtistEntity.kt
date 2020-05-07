package com.eshevtsov.android.guitar.assistant.database.entity

import androidx.room.*

@Entity(
    tableName = "favourite_artist",
    primaryKeys = ["user_id", "id"]
)
data class FavouriteArtistEntity(
    @ColumnInfo(name = "user_id")
    val userId: Long,

    @ColumnInfo(name = "id")
    override val id: Long
) : Unique