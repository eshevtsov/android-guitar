package com.eshevtsov.android.guitar.assistant.feature.album.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import coil.api.load
import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout
import com.eshevtsov.android.guitar.assistant.core.feature.view.view
import com.eshevtsov.android.guitar.assistant.feature.album.R
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumListItemModel

class AlbumListItemLayout(
    itemView: View,
    private val onItemClicked: (view: View, id: Long) -> Unit
) : Layout<AlbumListItemModel>(itemView) {

    private val albumNameTextView: TextView by view(R.id.albumNameTextView)
    private val albumYearTextView: TextView by view(R.id.albumYearTextView)
    private val albumCoverImageView: ImageView by view(R.id.albumCoverImageView)
    private val albumRootLayout: View by view(R.id.albumRootLayout)

    override fun bind(model: AlbumListItemModel, owner: LifecycleOwner) {
        albumNameTextView.text = model.name
        albumYearTextView.text = model.year.toString()
        if (model.coverUri != null) {
            albumCoverImageView.load(model.coverUri)
        }
        albumRootLayout.setOnClickListener { view -> onItemClicked(view, model.id) }
    }
}