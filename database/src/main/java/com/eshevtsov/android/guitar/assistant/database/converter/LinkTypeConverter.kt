package com.eshevtsov.android.guitar.assistant.database.converter

import androidx.room.TypeConverter
import com.eshevtsov.android.guitar.assistant.database.entity.LinkEntity

class LinkTypeConverter {
    @TypeConverter
    fun toString(genre: LinkEntity.Type): String = genre.name

    @TypeConverter
    fun fromString(name: String) = LinkEntity.Type.valueOf(name)
}