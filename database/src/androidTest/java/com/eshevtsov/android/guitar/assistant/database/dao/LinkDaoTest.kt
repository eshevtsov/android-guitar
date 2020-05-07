package com.eshevtsov.android.guitar.assistant.database.dao

import android.database.sqlite.SQLiteConstraintException
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eshevtsov.android.guitar.assistant.database.data.ArtistTestData
import com.eshevtsov.android.guitar.assistant.database.data.LinksTestData
import com.eshevtsov.android.guitar.assistant.database.data.ONE
import com.eshevtsov.android.guitar.assistant.database.entity.LinkEntity
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
class LinkDaoTest : BaseDaoTest<LinkEntity>() {
    override val dao: LinkDao
        get() = database.linkDao()

    override val testData = LinksTestData

    override suspend fun prepopulateDatabase() {
        database.artistDao().insert(
            listOf(ArtistTestData.first())
        )
    }

    @Test(expected = SQLiteConstraintException::class)
    fun insert_link_with_nonexistent_artist_throw_exception() = runBlockingTest {
        val nonexistentArtistId = ArtistTestData.withoutId().id
        val linkWithNonexistentArtist = LinksTestData.first().copy(
            artistForeignId = nonexistentArtistId
        )

        database.linkDao().insert(linkWithNonexistentArtist)
    }

    @Test
    fun get_link_by_id_after_delete_artist_return_null() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val artistId = database.artistDao().insert(artist)
        val link = LinksTestData.withoutId().copy(artistForeignId = artistId)
        val linkId = database.linkDao().insert(link)
        database.artistDao().delete(artistId)

        val actual = database.linkDao().get(linkId).take(ONE).single()

        assertThat(actual).isNull()
    }
}