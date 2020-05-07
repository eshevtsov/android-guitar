package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.eshevtsov.android.guitar.assistant.database.dto.ArtistWithLinksDto
import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArtistDao : BaseOperationsDao<ArtistEntity> {
    @Query("SELECT * FROM artist")
    override fun get(): Flow<List<ArtistEntity>>

    @Query("SELECT * FROM artist WHERE artist.id=:id")
    override fun get(id: Long): Flow<ArtistEntity>

    @Query("DELETE FROM artist WHERE artist.id IN(:ids)")
    override suspend fun delete(ids: List<Long>): Int

    @Query("DELETE FROM artist WHERE artist.id=:id")
    override suspend fun delete(id: Long): Int

    @Query("SELECT count(*) FROM artist")
    override suspend fun count(): Long

    @Transaction
    @Query("SELECT * FROM artist WHERE artist.id=:id")
    fun getWithLinks(id: Long): Flow<ArtistWithLinksDto>
}