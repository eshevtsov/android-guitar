package com.eshevtsov.android.guitar.assistant.feature.song.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.eshevtsov.android.guitar.assistant.core.feature.extension.defaultErrorObserve
import com.eshevtsov.android.guitar.assistant.core.feature.extension.observe
import com.eshevtsov.android.guitar.assistant.core.feature.recycler.RecyclerAdapter
import com.eshevtsov.android.guitar.assistant.feature.song.R
import com.eshevtsov.android.guitar.assistant.feature.song.core.ui.SongNavigation
import kotlinx.android.synthetic.main.fragment_song_list.*

class SongListFragment(
    private val viewModel: SongListViewModel,
    private val navigation: SongNavigation
) : Fragment(R.layout.fragment_song_list) {

    private val songListAdapter = RecyclerAdapter(
        R.layout.layout_song_list_item,
        createLayout = { view -> SongListItemLayout(view, navigation::toSongDetail) }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        songListRecyclerView.adapter = songListAdapter
    }

    private fun observeViewModel() = viewModel.run {
        defaultErrorObserve(this, navigation)
        observe(songList) { songListAdapter.updateItems(it) }
    }
}