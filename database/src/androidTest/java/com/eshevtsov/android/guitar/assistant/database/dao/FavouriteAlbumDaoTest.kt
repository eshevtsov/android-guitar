package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eshevtsov.android.guitar.assistant.database.data.*
import com.eshevtsov.android.guitar.assistant.database.dto.FavouriteAlbumListDto
import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteAlbumEntity
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
class FavouriteAlbumDaoTest : BaseDaoTest<FavouriteAlbumEntity>() {
    override val dao: FavouriteAlbumDao
        get() = database.favouriteAlbumDao()

    override val testData = FavouriteAlbumTestData

    override suspend fun prepopulateDatabase() {
        database.artistDao().insert(ArtistTestData.first())
        database.albumDao().insert(
            listOf(AlbumTestData.first(), AlbumTestData.second())
        )
        database.userDao().insert(
            listOf(UserTestData.first(), UserTestData.second())
        )
    }

    @Test
    fun get_favourite_album_list_return_expected() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val artistId = database.artistDao().insert(artist)
        val album = AlbumTestData.withoutId().copy(artistForeignId = artistId)
        val albumId = database.albumDao().insert(album)
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)
        val favouriteAlbum = FavouriteAlbumTestData.first().copy(
            id = albumId,
            userId = userId
        )
        database.favouriteAlbumDao().insert(favouriteAlbum)
        val expected = FavouriteAlbumListDto(userId, listOf(album.copy(id = albumId)))

        val actual = database.favouriteAlbumDao().getAlbumList(userId).take(ONE).single()

        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_empty_favourite_album_list_return_null() = runBlockingTest {
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)

        val actual = database.favouriteAlbumDao().getAlbumList(userId).take(ONE).single()

        Truth.assertThat(actual).isNull()
    }
}