package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.eshevtsov.android.guitar.assistant.database.dto.UserArtistListDto
import com.eshevtsov.android.guitar.assistant.database.dto.UserArtistWithAlbumsListDto
import com.eshevtsov.android.guitar.assistant.database.entity.UserArtistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserArtistDao : BaseOperationsDao<UserArtistEntity> {
    @Query("SELECT * FROM user_artist")
    override fun get(): Flow<List<UserArtistEntity>>

    @Query("SELECT * FROM user_artist WHERE user_artist.id=:id")
    override fun get(id: Long): Flow<UserArtistEntity>

    @Query("DELETE FROM user_artist WHERE user_artist.id IN(:ids)")
    override suspend fun delete(ids: List<Long>): Int

    @Query("DELETE FROM user_artist WHERE user_artist.id=:id")
    override suspend fun delete(id: Long): Int

    @Query("SELECT count(*) FROM user_artist")
    override suspend fun count(): Long

    @Transaction
    @Query("SELECT * FROM user_artist WHERE user_artist.user_id=:userId")
    fun getArtistList(userId: Long): Flow<UserArtistListDto>

    @Transaction
    @Query("SELECT * FROM user_artist WHERE user_artist.user_id=:userId")
    fun getArtistWithAlbumsList(userId: Long): Flow<UserArtistWithAlbumsListDto>

    @Query("SELECT count(*) FROM user_artist WHERE user_artist.user_id=:userId")
    suspend fun count(userId: Long): Long
}