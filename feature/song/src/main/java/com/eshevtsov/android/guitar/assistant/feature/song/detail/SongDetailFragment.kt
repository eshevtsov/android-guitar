package com.eshevtsov.android.guitar.assistant.feature.song.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.api.load
import com.eshevtsov.android.guitar.assistant.core.feature.extension.TAG
import com.eshevtsov.android.guitar.assistant.core.feature.extension.defaultErrorObserve
import com.eshevtsov.android.guitar.assistant.core.feature.extension.observe
import com.eshevtsov.android.guitar.assistant.core.feature.logger.Log
import com.eshevtsov.android.guitar.assistant.feature.song.R
import com.eshevtsov.android.guitar.assistant.feature.song.core.ui.SongNavigation
import com.eshevtsov.android.guitar.assistant.feature.song.detail.SongDetailContract.SONG_ID_EXTRA
import kotlinx.android.synthetic.main.fragment_song_detail.*

class SongDetailFragment(
    private val viewModel: SongDetailViewModel,
    private val navigation: SongNavigation
) : Fragment(R.layout.fragment_song_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initExtra()
        initView()
        observeViewModel()
    }

    private fun initExtra() {
        val songId = arguments?.getLong(SONG_ID_EXTRA)
        if (songId != null) {
            viewModel.loadDetails(songId)
        } else {
            Log.w(TAG, "No required `$SONG_ID_EXTRA` arguments extra.")
            requireActivity().onBackPressed()
        }
    }

    private fun initView() {
        toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
    }

    private fun observeViewModel() = viewModel.run {
        defaultErrorObserve(this, navigation)
        observe(artistName) { artistNameTextView.text = it }
        observe(name) { songNameTextView.text = it }
        observe(text) { songTextTextView.text = it }
        observe(albumCoverUri) { albumCoverImageView.load(it) }
    }
}