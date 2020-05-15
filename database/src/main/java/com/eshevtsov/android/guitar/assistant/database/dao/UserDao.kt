package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.eshevtsov.android.guitar.assistant.database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao : BaseOperationsDao<UserEntity> {
    @Query("SELECT * FROM user")
    override fun get(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE user.id=:id")
    override fun get(id: Long): Flow<UserEntity>

    @Query("DELETE FROM user WHERE user.id IN(:ids)")
    override suspend fun delete(ids: List<Long>): Int

    @Query("DELETE FROM user WHERE user.id=:id")
    override suspend fun delete(id: Long): Int

    @Query("SELECT count(*) FROM user")
    override suspend fun count(): Long

    @Query("SELECT * FROM user WHERE user.google_token_id=:token")
    fun getByGoogleToken(token: String): Flow<UserEntity>
}