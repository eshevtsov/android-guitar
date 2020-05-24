package com.eshevtsov.android.guitar.assistant.feature.album.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.eshevtsov.android.guitar.assistant.core.feature.extension.TAG
import com.eshevtsov.android.guitar.assistant.core.feature.extension.defaultErrorObserve
import com.eshevtsov.android.guitar.assistant.core.feature.extension.observe
import com.eshevtsov.android.guitar.assistant.core.feature.logger.Log
import com.eshevtsov.android.guitar.assistant.core.feature.recycler.RecyclerAdapter
import com.eshevtsov.android.guitar.assistant.feature.album.R
import com.eshevtsov.android.guitar.assistant.feature.album.core.ui.AlbumNavigation
import com.eshevtsov.android.guitar.assistant.feature.album.list.AlbumListContract.ARTIST_ID_EXTRA
import kotlinx.android.synthetic.main.fragment_album_list.*

class AlbumListFragment(
    private val navigation: AlbumNavigation,
    private val viewModel: AlbumListViewModel
) : Fragment(R.layout.fragment_album_list) {

    private val albumsListAdapter = RecyclerAdapter(
        R.layout.layout_album_grid_item,
        createLayout = { itemView ->
            AlbumListItemLayout(itemView) { view, id ->  }
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initExtra()
        initView()
        observeViewModel()
    }

    private fun initExtra() {
        val artistId = arguments?.getLong(ARTIST_ID_EXTRA)
        if (artistId != null) {
            viewModel.loadAlbums(artistId)
        } else {
            Log.w(TAG, "No required `$ARTIST_ID_EXTRA` arguments extra.")
            requireActivity().onBackPressed()
        }
    }

    private fun initView() {
        albumsListRecyclerView.adapter = albumsListAdapter
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun observeViewModel() = viewModel.run {
        defaultErrorObserve(this, navigation)
        observe(albumList) { albumsListAdapter.updateItems(it) }
    }
}