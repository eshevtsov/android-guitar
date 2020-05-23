package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.eshevtsov.android.guitar.assistant.database.dto.AlbumDetailsDto
import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao : BaseOperationsDao<AlbumEntity> {
    @Query("SELECT * FROM album")
    override fun get(): Flow<List<AlbumEntity>>

    @Query("SELECT * FROM album WHERE album.id=:id")
    override fun get(id: Long): Flow<AlbumEntity>

    @Query("DELETE FROM album WHERE album.id IN(:ids)")
    override suspend fun delete(ids: List<Long>): Int

    @Query("DELETE FROM album WHERE album.id=:id")
    override suspend fun delete(id: Long): Int

    @Query("SELECT count(*) FROM album")
    override suspend fun count(): Long

    @Query("SELECT * FROM album WHERE album.artist_foreign_id=:artistId")
    fun getByArtist(artistId: Long): Flow<List<AlbumEntity>>

    @Transaction
    @Query("SELECT * FROM album WHERE album.id=:id")
    fun getDetails(id: Long): Flow<AlbumDetailsDto>

    @Query("SELECT count(*) FROM album WHERE album.artist_foreign_id=:artistId")
    suspend fun count(artistId: Long): Long
}