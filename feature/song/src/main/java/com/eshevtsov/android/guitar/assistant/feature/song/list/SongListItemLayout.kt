package com.eshevtsov.android.guitar.assistant.feature.song.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import coil.api.load
import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout
import com.eshevtsov.android.guitar.assistant.core.feature.view.view
import com.eshevtsov.android.guitar.assistant.feature.song.R
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongListItemModel

class SongListItemLayout(
    itemView: View,
    private val onItemClicked: (view: View, id: Long) -> Unit
) : Layout<SongListItemModel>(itemView) {

    private val songNameTextView: TextView by view(R.id.songNameTextView)
    private val songArtistTextView: TextView by view(R.id.songArtistTextView)
    private val songIconImageView: ImageView by view(R.id.songIconImageView)
    private val songItemRootLayout: View by view(R.id.songItemRootLayout)

    override fun bind(model: SongListItemModel, owner: LifecycleOwner) {
        songNameTextView.text = model.name
        songArtistTextView.text = model.artistName
        if (model.coverUri != null) {
            songIconImageView.load(model.coverUri)
        }
        songItemRootLayout.setOnClickListener { view ->
            onItemClicked(view, model.id)
        }
    }
}