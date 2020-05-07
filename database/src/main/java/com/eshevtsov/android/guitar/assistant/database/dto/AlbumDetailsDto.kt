package com.eshevtsov.android.guitar.assistant.database.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity
import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity
import com.eshevtsov.android.guitar.assistant.database.entity.SongEntity

data class AlbumDetailsDto(
    @Embedded
    val album: AlbumEntity,

    @Relation(
        parentColumn = "artist_foreign_id",
        entityColumn = "id"
    )
    val artist: ArtistEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "album_foreign_id",
        entity = SongEntity::class
    )
    val songs: List<SongNameDto>
)