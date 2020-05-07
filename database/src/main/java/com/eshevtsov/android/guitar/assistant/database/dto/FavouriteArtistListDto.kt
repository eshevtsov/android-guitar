package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.ColumnInfo
import androidx.room.Junction
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity
import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteArtistEntity

data class FavouriteArtistListDto(
    @ColumnInfo(name = "user_id")
    val id: Long,

    @Relation(
        parentColumn = "user_id",
        entityColumn = "id",
        associateBy = Junction(FavouriteArtistEntity::class)
    )
    val artistList: List<ArtistEntity>
)