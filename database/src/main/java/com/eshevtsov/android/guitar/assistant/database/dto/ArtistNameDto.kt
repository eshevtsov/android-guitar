package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.ColumnInfo

data class ArtistNameDto(
    @ColumnInfo(name = "name")
    val name: String
)