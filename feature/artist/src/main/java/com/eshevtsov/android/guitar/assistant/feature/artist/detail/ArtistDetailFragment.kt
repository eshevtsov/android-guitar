package com.eshevtsov.android.guitar.assistant.feature.artist.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.api.load
import com.eshevtsov.android.guitar.assistant.core.feature.extension.TAG
import com.eshevtsov.android.guitar.assistant.core.feature.extension.defaultErrorObserve
import com.eshevtsov.android.guitar.assistant.core.feature.extension.observe
import com.eshevtsov.android.guitar.assistant.core.feature.logger.Log
import com.eshevtsov.android.guitar.assistant.core.feature.recycler.RecyclerAdapter
import com.eshevtsov.android.guitar.assistant.feature.artist.R
import com.eshevtsov.android.guitar.assistant.feature.artist.core.ui.ArtistNavigation
import com.eshevtsov.android.guitar.assistant.feature.artist.core.ui.LinkLayout
import com.eshevtsov.android.guitar.assistant.feature.artist.detail.ArtistDetailContract.ARTIST_ID_EXTRA
import kotlinx.android.synthetic.main.fragment_artist_detail.*

class ArtistDetailFragment(
    private val viewModel: ArtistDetailViewModel,
    private val navigation: ArtistNavigation
) : Fragment(R.layout.fragment_artist_detail) {

    private val linkListAdapter = RecyclerAdapter(R.layout.layout_link_list_item, ::LinkLayout)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initExtra()
        initView()
        observeViewModel()
    }

    private fun initExtra() {
        val artistId = arguments?.getLong(ARTIST_ID_EXTRA)
        if (artistId != null) {
            viewModel.loadDetails(artistId)
        } else {
            Log.w(TAG, "No required `$ARTIST_ID_EXTRA` arguments extra.")
            requireActivity().onBackPressed()
        }
    }

    private fun initView() {
        linksRecyclerView.adapter = linkListAdapter
        toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        albumsButton.setOnClickListener { viewModel.onAlbumsButtonCLicked() }
    }

    private fun observeViewModel() = viewModel.run {
        defaultErrorObserve(this, navigation)
        observe(linkList) { linkListAdapter.updateItems(it) }
        observe(title) { toolbar.title = it }
        observe(iconUri) { artistIconImageView.load(it) }
        observe(navigateToAlbumListEvent) { navigation.toAlbumList(requireView(), it) }
    }
}