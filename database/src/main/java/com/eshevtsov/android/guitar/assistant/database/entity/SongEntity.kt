package com.eshevtsov.android.guitar.assistant.database.entity

import androidx.room.*

@Entity(
    tableName = "song",
    foreignKeys = [
        ForeignKey(
            entity = AlbumEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("album_foreign_id"),
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["album_foreign_id"])
    ]
)
data class SongEntity(
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "album_foreign_id")
    val albumForeignId: Long,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override val id: Long = 0L,

    @ColumnInfo(name = "time")
    val timeMilliseconds: Long? = null,

    @ColumnInfo(name = "text")
    val text: String? = null,

    @ColumnInfo(name = "number_in_album")
    val numberInAlbum: Int? = null
) : Unique