package com.eshevtsov.android.guitar.assistant.feature.album.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.api.load
import com.eshevtsov.android.guitar.assistant.core.feature.extension.TAG
import com.eshevtsov.android.guitar.assistant.core.feature.extension.defaultErrorObserve
import com.eshevtsov.android.guitar.assistant.core.feature.extension.observe
import com.eshevtsov.android.guitar.assistant.core.feature.logger.Log
import com.eshevtsov.android.guitar.assistant.core.feature.recycler.RecyclerAdapter
import com.eshevtsov.android.guitar.assistant.feature.album.R
import com.eshevtsov.android.guitar.assistant.feature.album.core.ui.AlbumNavigation
import com.eshevtsov.android.guitar.assistant.feature.album.core.ui.SongListItemLayout
import com.eshevtsov.android.guitar.assistant.feature.album.detail.AlbumDetailContract.ALBUM_ID_EXTRA
import kotlinx.android.synthetic.main.fragment_album_detail.*

class AlbumDetailFragment(
    private val navigation: AlbumNavigation,
    private val viewModel: AlbumDetailViewModel
) : Fragment(R.layout.fragment_album_detail) {

    private val songListAdapter = RecyclerAdapter(
        R.layout.layout_album_song_list_item,
        createLayout = { itemView ->
            SongListItemLayout(itemView) { view, id ->  }
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initExtra()
        initView()
        observeViewModel()
    }

    private fun initExtra() {
        val albumId = arguments?.getLong(ALBUM_ID_EXTRA)
        if (albumId != null) {
            viewModel.loadDetails(albumId)
        } else {
            Log.w(TAG, "No required `$ALBUM_ID_EXTRA` arguments extra.")
            requireActivity().onBackPressed()
        }
    }

    private fun initView() {
        songsRecyclerView.adapter = songListAdapter
        toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
    }

    private fun observeViewModel() = viewModel.run {
        defaultErrorObserve(this, navigation)
        observe(songList) { songListAdapter.updateItems(it) }
        observe(title) { albumNameTextView.text = it }
        observe(artistName) { albumArtistTextView.text = it }
        observe(year) { albumYearTextView.text = it }
        observe(coverUri) { albumCoverImageView.load(it) }
    }
}