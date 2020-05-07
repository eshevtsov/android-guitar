package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.ColumnInfo

data class SongNameDto(
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "name")
    val name: String
)