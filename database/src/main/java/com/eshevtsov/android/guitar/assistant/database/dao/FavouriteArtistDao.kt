package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.eshevtsov.android.guitar.assistant.database.dto.FavouriteArtistListDto
import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteArtistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteArtistDao : BaseOperationsDao<FavouriteArtistEntity> {
    @Query("SELECT * FROM favourite_artist")
    override fun get(): Flow<List<FavouriteArtistEntity>>

    @Query("SELECT * FROM favourite_artist WHERE favourite_artist.id=:id")
    override fun get(id: Long): Flow<FavouriteArtistEntity>

    @Query("DELETE FROM favourite_artist WHERE favourite_artist.id IN(:ids)")
    override suspend fun delete(ids: List<Long>): Int

    @Query("DELETE FROM favourite_artist WHERE favourite_artist.id=:id")
    override suspend fun delete(id: Long): Int

    @Query("SELECT count(*) FROM favourite_artist")
    override suspend fun count(): Long

    @Transaction
    @Query("SELECT * FROM favourite_artist WHERE favourite_artist.user_id=:userId")
    fun getArtistList(userId: Long): Flow<FavouriteArtistListDto>
}