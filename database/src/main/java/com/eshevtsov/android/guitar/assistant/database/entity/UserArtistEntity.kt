package com.eshevtsov.android.guitar.assistant.database.entity

import androidx.room.*

@Entity(
    tableName = "user_artist",
    primaryKeys = ["user_id", "id"]
)
data class UserArtistEntity(
    @ColumnInfo(name = "user_id")
    val userId: Long,

    @ColumnInfo(name = "id")
    override val id: Long
) : Unique