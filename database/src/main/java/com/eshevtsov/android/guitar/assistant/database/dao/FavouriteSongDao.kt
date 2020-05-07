package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.eshevtsov.android.guitar.assistant.database.dto.FavouriteSongListDto
import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteSongEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteSongDao : BaseOperationsDao<FavouriteSongEntity> {
    @Query("SELECT * FROM favourite_song")
    override fun get(): Flow<List<FavouriteSongEntity>>

    @Query("SELECT * FROM favourite_song WHERE favourite_song.id=:id")
    override fun get(id: Long): Flow<FavouriteSongEntity>

    @Query("DELETE FROM favourite_song WHERE favourite_song.id IN(:ids)")
    override suspend fun delete(ids: List<Long>): Int

    @Query("DELETE FROM favourite_song WHERE favourite_song.id=:id")
    override suspend fun delete(id: Long): Int

    @Query("SELECT count(*) FROM favourite_song")
    override suspend fun count(): Long

    @Transaction
    @Query("SELECT * FROM favourite_song WHERE favourite_song.user_id=:userId")
    fun getSongList(userId: Long): Flow<FavouriteSongListDto>
}