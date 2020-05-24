package com.eshevtsov.android.guitar.assistant.feature.album.core.ui

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout
import com.eshevtsov.android.guitar.assistant.core.feature.view.view
import com.eshevtsov.android.guitar.assistant.feature.album.R
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.SongListItemModel

class SongListItemLayout(
    itemView: View,
    private val onItemClicked: (view: View, id: Long) -> Unit
) : Layout<SongListItemModel>(itemView) {

    private val songNumberInAlbumTextView: TextView by view(R.id.songNumberInAlbumTextView)
    private val songNameTextView: TextView by view(R.id.songNameTextView)
    private val songRootLayout: View by view(R.id.songRootLayout)

    override fun bind(model: SongListItemModel, owner: LifecycleOwner) {
        songNumberInAlbumTextView.text = model.numberInAlbum?.toString()
        songNameTextView.text = model.name
        songRootLayout.setOnClickListener { view -> onItemClicked(view, model.id) }
    }
}