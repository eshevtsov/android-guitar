package com.eshevtsov.android.guitar.assistant.koin.feature

import com.eshevtsov.android.guitar.assistant.feature.artist.core.data.*
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistInteractor
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistRepository
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.DefaultArtistInteractor
import com.eshevtsov.android.guitar.assistant.feature.artist.detail.ArtistDetailFragment
import com.eshevtsov.android.guitar.assistant.feature.artist.detail.ArtistDetailViewModel
import com.eshevtsov.android.guitar.assistant.feature.artist.detail.DefaultArtistDetailViewModel
import com.eshevtsov.android.guitar.assistant.feature.artist.list.ArtistListFragment
import com.eshevtsov.android.guitar.assistant.feature.artist.list.ArtistListViewModel
import com.eshevtsov.android.guitar.assistant.feature.artist.list.DefaultArtistListViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ArtistModule {
    val default = module {
        single<LinkEntityToModelMapper> { DefaultLinkEntityToModelMapper() }
        single<ArtistEntityToDetailModelMapper> { DefaultArtistEntityToDetailModelMapper(get()) }
        single<ArtistEntityToListModelMapper> { DefaultArtistEntityToListModelMapper(get()) }
        single<ArtistInteractor> { DefaultArtistInteractor(get(), get()) }
        single<ArtistRepository> { DefaultArtistRepository(get(), get(), get(), get(), get(), get()) }
        viewModel<ArtistDetailViewModel> { DefaultArtistDetailViewModel(get()) }
        viewModel<ArtistListViewModel> { DefaultArtistListViewModel(get()) }
        fragment { ArtistListFragment(get(), get()) }
        fragment { ArtistDetailFragment(get(), get()) }
    }
}