package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eshevtsov.android.guitar.assistant.database.data.*
import com.eshevtsov.android.guitar.assistant.database.dto.FavouriteArtistListDto
import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteArtistEntity
import com.google.common.truth.Truth
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
class FavouriteArtistDaoTest : BaseDaoTest<FavouriteArtistEntity>() {
    override val dao: FavouriteArtistDao
        get() = database.favouriteArtistDao()

    override val testData = FavouriteArtistTestData

    override suspend fun prepopulateDatabase() {
        database.artistDao().insert(
            listOf(ArtistTestData.first(), ArtistTestData.second())
        )
        database.userDao().insert(
            listOf(UserTestData.first(), UserTestData.second())
        )
    }

    @Test
    fun get_favourite_artist_list_return_expected() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val artistId = database.artistDao().insert(artist)
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)
        val favouriteArtist = FavouriteArtistTestData.first().copy(
            id = artistId,
            userId = userId
        )
        database.favouriteArtistDao().insert(favouriteArtist)
        val expected = FavouriteArtistListDto(userId, listOf(artist.copy(id = artistId)))

        val actual = database.favouriteArtistDao().getArtistList(userId).take(ONE).single()

        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_empty_favourite_artist_list_return_null() = runBlockingTest {
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)

        val actual = database.favouriteArtistDao().getArtistList(userId).take(ONE).single()

        Truth.assertThat(actual).isNull()
    }
}