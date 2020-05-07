package com.eshevtsov.android.guitar.assistant.database.converter

import androidx.room.TypeConverter
import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity

class AlbumGenreTypeConverter {
    @TypeConverter
    fun toString(genre: AlbumEntity.Genre): String = genre.name

    @TypeConverter
    fun fromString(name: String) = AlbumEntity.Genre.valueOf(name)
}