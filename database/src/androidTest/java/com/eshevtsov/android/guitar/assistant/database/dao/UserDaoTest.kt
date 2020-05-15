package com.eshevtsov.android.guitar.assistant.database.dao

import android.database.sqlite.SQLiteConstraintException
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eshevtsov.android.guitar.assistant.database.data.*
import com.eshevtsov.android.guitar.assistant.database.entity.UserEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith

@FlowPreview
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class UserDaoTest : BaseDaoTest<UserEntity>() {

    override val testData = UserTestData
    override val dao: UserDao
        get() = database.userDao()

    @Test(expected = SQLiteConstraintException::class)
    fun insert_user_with_existing_google_token_throw_exception() = runBlockingTest {
        val user = UserTestData.first()
        database.userDao().insert(user)

        val userWithTheSameGoogleToken = user.copy()
        database.userDao().insert(userWithTheSameGoogleToken)
    }

    @Test
    fun get_user_by_google_token_return_expected() = runBlockingTest {
        val expected = UserTestData.first()
        database.userDao().insert(expected)

        val token = expected.googleTokenId
        val actual = database.userDao().getByGoogleToken(token).take(ONE).single()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_user_by_nonexistent_google_token_return_null() = runBlockingTest {
        val existingUser = UserTestData.first()
        database.userDao().insert(existingUser)

        val nonexistentToken = UserTestData.second().googleTokenId
        val actual = database.userDao().getByGoogleToken(nonexistentToken).take(ONE).single()

        assertThat(actual).isNull()
    }
}