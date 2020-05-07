package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.ColumnInfo
import androidx.room.Junction
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity
import com.eshevtsov.android.guitar.assistant.database.entity.UserArtistEntity

data class UserArtistWithAlbumsListDto(
    @ColumnInfo(name = "user_id")
    val id: Long,

    @Relation(
        parentColumn = "user_id",
        entityColumn = "id",
        associateBy = Junction(UserArtistEntity::class),
        entity = ArtistEntity::class
    )
    val artistList: List<ArtistWithAlbumsDto>
)