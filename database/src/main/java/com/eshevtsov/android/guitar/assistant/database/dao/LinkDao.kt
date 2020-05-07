package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.eshevtsov.android.guitar.assistant.database.entity.LinkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LinkDao : BaseOperationsDao<LinkEntity> {
    @Query("SELECT * FROM link")
    override fun get(): Flow<List<LinkEntity>>

    @Query("SELECT * FROM link WHERE link.id=:id")
    override fun get(id: Long): Flow<LinkEntity>

    @Query("DELETE FROM link WHERE link.id IN(:ids)")
    override suspend fun delete(ids: List<Long>): Int

    @Query("DELETE FROM link WHERE link.id=:id")
    override suspend fun delete(id: Long): Int

    @Query("SELECT count(*) FROM link")
    override suspend fun count(): Long
}