package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.eshevtsov.android.guitar.assistant.database.dto.SongDetailsDto
import com.eshevtsov.android.guitar.assistant.database.dto.SongSimpleDto
import com.eshevtsov.android.guitar.assistant.database.entity.SongEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDao : BaseOperationsDao<SongEntity> {
    @Query("SELECT * FROM song")
    override fun get(): Flow<List<SongEntity>>

    @Query("SELECT * FROM song WHERE song.id=:id")
    override fun get(id: Long): Flow<SongEntity>

    @Query("DELETE FROM song WHERE song.id IN(:ids)")
    override suspend fun delete(ids: List<Long>): Int

    @Query("DELETE FROM song WHERE song.id=:id")
    override suspend fun delete(id: Long): Int

    @Query("SELECT count(*) FROM song")
    override suspend fun count(): Long

    @Transaction
    @Query("SELECT * FROM song WHERE song.id=:id")
    fun getDetails(id: Long): Flow<SongDetailsDto>

    @Transaction
    @Query("SELECT * FROM song WHERE song.id=:id")
    fun getSimple(id: Long): Flow<SongSimpleDto>
}