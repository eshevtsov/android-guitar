package com.eshevtsov.android.guitar.assistant.database.entity

import androidx.room.*

@Entity(
    tableName = "link",
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
data class LinkEntity(
    @ColumnInfo(name = "value")
    val value: String,

    @ColumnInfo(name = "artist_foreign_id")
    val artistForeignId: Long,

    @ColumnInfo(name = "type")
    val type: Type = Type.Unknown,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override val id: Long = 0L
) : Unique {
    enum class Type {
        Unknown,
        Facebook,
        Instagram,
        Twitter,
        Youtube
    }
}