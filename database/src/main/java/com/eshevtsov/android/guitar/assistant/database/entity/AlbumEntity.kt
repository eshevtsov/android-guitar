package com.eshevtsov.android.guitar.assistant.database.entity

import androidx.room.*

@Entity(
    tableName = "album",
    foreignKeys = [
        ForeignKey(
            entity = ArtistEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("artist_foreign_id"),
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["artist_foreign_id"])
    ]
)
data class AlbumEntity(
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "artist_foreign_id")
    val artistForeignId: Long,

    @ColumnInfo(name = "genre")
    val genre: Genre = Genre.Unknown,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override val id: Long = 0L,

    @ColumnInfo(name = "year")
    val year: Int? = null,

    @ColumnInfo(name = "cover")
    val coverUri: String? = null
) : Unique {
    enum class Genre {
        Unknown,
        Roc,
        KPop,
        Alternative
    }
}