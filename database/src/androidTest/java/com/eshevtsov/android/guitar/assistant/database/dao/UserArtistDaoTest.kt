package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eshevtsov.android.guitar.assistant.database.data.ArtistTestData
import com.eshevtsov.android.guitar.assistant.database.data.ONE
import com.eshevtsov.android.guitar.assistant.database.data.UserArtistTestData
import com.eshevtsov.android.guitar.assistant.database.data.UserTestData
import com.eshevtsov.android.guitar.assistant.database.dto.UserArtistListDto
import com.eshevtsov.android.guitar.assistant.database.entity.UserArtistEntity
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
class UserArtistDaoTest : BaseDaoTest<UserArtistEntity>() {
    override val dao: UserArtistDao
        get() = database.userArtistDao()

    override val testData = UserArtistTestData

    override suspend fun prepopulateDatabase() {
        database.artistDao().insert(
            listOf(ArtistTestData.first(), ArtistTestData.second())
        )
        database.userDao().insert(
            listOf(UserTestData.first(), UserTestData.second())
        )
    }

    @Test
    fun get_user_artist_list_return_expected() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val artistId = database.artistDao().insert(artist)
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)
        val userArtist = UserArtistTestData.first().copy(
            id = artistId,
            userId = userId
        )
        database.userArtistDao().insert(userArtist)
        val expected = UserArtistListDto(userId, listOf(artist.copy(id = artistId)))

        val actual = database.userArtistDao().getArtistList(userId).take(ONE).single()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_empty_user_artist_list_return_null() = runBlockingTest {
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)

        val actual = database.userArtistDao().getArtistList(userId).take(ONE).single()

        assertThat(actual).isNull()
    }
}