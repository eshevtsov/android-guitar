package com.eshevtsov.android.guitar.assistant.koin.feature

import com.eshevtsov.android.guitar.assistant.feature.artist.data.ArtistEntityToListModelMapper
import com.eshevtsov.android.guitar.assistant.feature.artist.data.DefaultArtistEntityToListModelMapper
import com.eshevtsov.android.guitar.assistant.feature.artist.data.DefaultArtistRepository
import com.eshevtsov.android.guitar.assistant.feature.artist.domain.ArtistInteractor
import com.eshevtsov.android.guitar.assistant.feature.artist.domain.ArtistRepository
import com.eshevtsov.android.guitar.assistant.feature.artist.domain.DefaultArtistInteractor
import com.eshevtsov.android.guitar.assistant.feature.artist.ui.ArtistListFragment
import com.eshevtsov.android.guitar.assistant.feature.artist.ui.ArtistListViewModel
import com.eshevtsov.android.guitar.assistant.feature.artist.ui.DefaultArtistListViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ArtistModule {
    val default = module {
        single<ArtistEntityToListModelMapper> {
            DefaultArtistEntityToListModelMapper(
                get()
            )
        }
        single<ArtistInteractor> {
            DefaultArtistInteractor(
                get(),
                get()
            )
        }
        single<ArtistRepository> {
            DefaultArtistRepository(
                get(),
                get(),
                get(),
                get()
            )
        }
        viewModel<ArtistListViewModel> {
            DefaultArtistListViewModel(
                get()
            )
        }
        fragment {
            ArtistListFragment(
                get()
            )
        }
    }
}