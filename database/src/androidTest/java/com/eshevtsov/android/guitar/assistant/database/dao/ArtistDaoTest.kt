package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eshevtsov.android.guitar.assistant.database.data.ArtistTestData
import com.eshevtsov.android.guitar.assistant.database.data.LinksTestData
import com.eshevtsov.android.guitar.assistant.database.data.ONE
import com.eshevtsov.android.guitar.assistant.database.dto.ArtistWithLinksDto
import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity
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
class ArtistDaoTest : BaseDaoTest<ArtistEntity>() {
    override val dao: ArtistDao
        get() = database.artistDao()

    override val testData = ArtistTestData

    @Test
    fun get_artist_with_links_return_expected() = runBlockingTest {
        val artist = ArtistTestData.first()
        database.artistDao().insert(artist)
        val links = listOf(LinksTestData.first(), LinksTestData.second())
        database.linkDao().insert(links)
        val expected = ArtistWithLinksDto(artist, links)

        val actual = database.artistDao().getWithLinks(artist.id).take(ONE).single()

        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_artist_without_links_return_expected() = runBlockingTest {
        val artist = ArtistTestData.first()
        database.artistDao().insert(artist)
        val expected = ArtistWithLinksDto(artist, emptyList())

        val actual = database.artistDao().getWithLinks(artist.id).take(ONE).single()

        Truth.assertThat(actual).isEqualTo(expected)
    }
}