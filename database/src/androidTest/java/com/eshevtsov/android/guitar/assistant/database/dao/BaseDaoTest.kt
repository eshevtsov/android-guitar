package com.eshevtsov.android.guitar.assistant.database.dao

import android.database.sqlite.SQLiteConstraintException
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.eshevtsov.android.guitar.assistant.database.GuitarAssistantDatabase
import com.eshevtsov.android.guitar.assistant.database.data.*
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
abstract class BaseDaoTest<T : Any> : CoroutineScope {
    private val dispatcher = TestCoroutineDispatcher()
    private val executor = dispatcher.asExecutor()

    protected lateinit var database: GuitarAssistantDatabase

    override val coroutineContext: CoroutineContext = dispatcher

    abstract val dao: BaseOperationsDao<T>
    abstract val testData: TestData<T>
    open suspend fun prepopulateDatabase() {}

    @Before
    fun before() {
        Dispatchers.setMain(dispatcher)

        database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            GuitarAssistantDatabase::class.java
        )
            .setTransactionExecutor(executor)
            .setQueryExecutor(executor)
            .build()

        runBlockingTest {
            prepopulateDatabase()
        }
    }

    @After
    fun after() {
        database.close()
        dispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
    }

    @Test
    fun entities_count_return_expected() = runBlockingTest {
        val entitiesList = listOf(
            testData.first(),
            testData.second()
        )
        val expected = entitiesList.size
        dao.insert(entitiesList)

        val actual = dao.count()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun table_count_after_delete_all_entities_return_zero() = runBlockingTest {
        val expected = ZERO
        val entity = testData.first()
        val id = dao.insert(entity)
        dao.delete(id)

        val actual = dao.count()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun empty_entities_table_count_return_zero() = runBlockingTest {
        val expected = ZERO

        val actual = dao.count()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun insert_one_entity_return_id_greater_than_zero() = runBlockingTest {
        val entity = testData.withoutId()

        val actual = dao.insert(entity)

        assertThat(actual).isGreaterThan(ZERO)
    }

    @Test(expected = SQLiteConstraintException::class)
    fun insert_entity_with_existing_key_throw_exception() = runBlockingTest {
        val entity = testData.first()
        val anotherEntity = testData.second()
        val id = dao.insert(entity)

        val entityWithTheSameId = testData.copy(anotherEntity, id)
        dao.insert(entityWithTheSameId)
    }

    @Test
    fun insert_list_entity_return_ids_greater_than_zero() = runBlockingTest {
        val entitiesList = listOf(
            testData.first(),
            testData.second()
        )

        val actual = dao.insert(entitiesList)

        actual.forEach {
            assertThat(it).isGreaterThan(ZERO)
        }
    }

    @Test
    fun insert_list_entity_return_ids_with_no_duplicates() = runBlockingTest {
        val entitiesList = listOf(
            testData.first(),
            testData.second()
        )

        val actual = dao.insert(entitiesList)

        assertThat(actual).containsNoDuplicates()
    }

    @Test
    fun insert_list_entity_return_ids_with_correct_list_size() = runBlockingTest {
        val entitiesList = listOf(
            testData.first(),
            testData.second()
        )
        val expected = entitiesList.size

        val actual = dao.insert(entitiesList).size

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_entity_by_id_return_expected() = runBlockingTest {
        val expected = testData.first()
        val id = dao.insert(expected)

        val actual = dao.get(id).take(ONE).single()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_all_entities_return_expected() = runBlockingTest {
        val expected = listOf(
            testData.first(),
            testData.second()
        )
        dao.insert(expected)

        val actual = dao.get().take(ONE).single()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_deleted_entity_by_id_return_null() = runBlockingTest {
        val entity = testData.first()
        val id = dao.insert(entity)
        dao.delete(id)

        val actual = dao.get(id).take(ONE).single()

        assertThat(actual).isNull()
    }

    @Test
    fun get_entity_after_update_return_expected() = runBlockingTest {
        val entity = testData.first()
        val anotherDataEntity = testData.second()
        val id = dao.insert(entity)
        val expected = testData.copy(anotherDataEntity, id)
        dao.update(expected)

        val actual = dao.get(id).take(ONE).single()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun delete_entity_return_one_deleted_rows_count() = runBlockingTest {
        val expected = ONE
        val entity = testData.first()
        val id = dao.insert(entity)

        val actual = dao.delete(id)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun update_entity_return_zero_updated_rows_count() = runBlockingTest {
        val expected = ONE
        val entity = testData.first()
        val anotherDataEntity = testData.second()
        val id = dao.insert(entity)
        val entityToUpdate = testData.copy(anotherDataEntity, id)

        val actual = dao.update(entityToUpdate)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun update_entity_without_id_return_zero_updated_rows_count() = runBlockingTest {
        val expected = ZERO
        val entity = testData.first()
        val anotherDataEntity = testData.withoutId()
        dao.insert(entity)

        val actual = dao.update(anotherDataEntity)

        assertThat(actual).isEqualTo(expected)
    }
}