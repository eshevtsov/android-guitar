package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow

interface BaseOperationsDao<T> {
    fun get(): Flow<List<T>>

    fun get(id: Long): Flow<T>

    suspend fun delete(ids: List<Long>): Int

    suspend fun delete(id: Long): Int

    suspend fun count(): Long

    @Update
    suspend fun update(items: List<T>): Int

    @Update
    suspend fun update(item: T): Int

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(items: List<T>): List<Long>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(item: T): Long
}