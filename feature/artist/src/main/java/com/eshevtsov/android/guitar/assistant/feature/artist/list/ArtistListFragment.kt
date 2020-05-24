package com.eshevtsov.android.guitar.assistant.feature.artist.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.eshevtsov.android.guitar.assistant.core.feature.extension.observe
import com.eshevtsov.android.guitar.assistant.core.feature.recycler.RecyclerAdapter
import com.eshevtsov.android.guitar.assistant.feature.artist.R
import kotlinx.android.synthetic.main.fragment_artist_list.*

class ArtistListFragment(
    private val viewModel: ArtistListViewModel
) : Fragment(R.layout.fragment_artist_list) {

    private val artistListAdapter =
        RecyclerAdapter(R.layout.layout_artist_list_item, ::ArtistListItemLayout)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        artistListRecyclerView.adapter = artistListAdapter
    }

    private fun observeViewModel() = viewModel.run {
        observe(artistList) { artistListAdapter.updateItems(it) }
    }
}