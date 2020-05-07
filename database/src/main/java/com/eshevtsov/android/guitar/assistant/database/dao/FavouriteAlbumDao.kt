package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.eshevtsov.android.guitar.assistant.database.dto.FavouriteAlbumListDto
import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteAlbumEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteAlbumDao : BaseOperationsDao<FavouriteAlbumEntity> {
    @Query("SELECT * FROM favourite_album")
    override fun get(): Flow<List<FavouriteAlbumEntity>>

    @Query("SELECT * FROM favourite_album WHERE favourite_album.id=:id")
    override fun get(id: Long): Flow<FavouriteAlbumEntity>

    @Query("DELETE FROM favourite_album WHERE favourite_album.id IN(:ids)")
    override suspend fun delete(ids: List<Long>): Int

    @Query("DELETE FROM favourite_album WHERE favourite_album.id=:id")
    override suspend fun delete(id: Long): Int

    @Query("SELECT count(*) FROM favourite_album")
    override suspend fun count(): Long

    @Transaction
    @Query("SELECT * FROM favourite_album WHERE favourite_album.user_id=:userId")
    fun getAlbumList(userId: Long): Flow<FavouriteAlbumListDto>
}