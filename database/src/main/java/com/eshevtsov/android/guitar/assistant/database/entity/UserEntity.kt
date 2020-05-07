package com.eshevtsov.android.guitar.assistant.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user",
    indices = [
        Index(value = ["google_token_hash"], unique = true)
    ]
)
data class UserEntity(
    @ColumnInfo(name = "google_token_hash")
    val googleTokenHash: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override val id: Long = 0L
) : Unique