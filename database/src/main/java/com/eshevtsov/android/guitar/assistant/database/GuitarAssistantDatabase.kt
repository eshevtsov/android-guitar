package com.eshevtsov.android.guitar.assistant.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eshevtsov.android.guitar.assistant.database.converter.AlbumGenreTypeConverter
import com.eshevtsov.android.guitar.assistant.database.converter.LinkTypeConverter
import com.eshevtsov.android.guitar.assistant.database.dao.*
import com.eshevtsov.android.guitar.assistant.database.entity.*

@Database(
    entities = [
        AlbumEntity::class,
        ArtistEntity::class,
        FavouriteAlbumEntity::class,
        FavouriteArtistEntity::class,
        FavouriteSongEntity::class,
        LinkEntity::class,
        SongEntity::class,
        UserArtistEntity::class,
        UserEntity::class
    ],
    version = DATABASE_VERSION
)
@TypeConverters(
    value = [
        AlbumGenreTypeConverter::class,
        LinkTypeConverter::class
    ]
)
abstract class GuitarAssistantDatabase : RoomDatabase() {

    companion object {
        const val NAME = "guitar-assistant-database"
        const val VERSION = DATABASE_VERSION

        fun get(context: Context): GuitarAssistantDatabase =
            Room.databaseBuilder(context, GuitarAssistantDatabase::class.java, NAME)
                .build()
    }

    abstract fun albumDao(): AlbumDao
    abstract fun artistDao(): ArtistDao
    abstract fun favouriteAlbumDao(): FavouriteAlbumDao
    abstract fun favouriteArtistDao(): FavouriteArtistDao
    abstract fun favouriteSongDao(): FavouriteSongDao
    abstract fun linkDao(): LinkDao
    abstract fun songDao(): SongDao
    abstract fun userArtistDao(): UserArtistDao
    abstract fun userDao(): UserDao
}

private const val DATABASE_VERSION = 1