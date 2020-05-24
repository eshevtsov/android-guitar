package com.eshevtsov.android.guitar.assistant.feature.artist.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import coil.api.load
import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout
import com.eshevtsov.android.guitar.assistant.core.feature.view.view
import com.eshevtsov.android.guitar.assistant.feature.artist.R
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistListItemModel

class ArtistListItemLayout(
    itemView: View,
    private val onItemClicked: (view: View, id: Long) -> Unit
) : Layout<ArtistListItemModel>(itemView) {

    private val artistNameTextView: TextView by view(R.id.artistNameTextView)
    private val artistInformationTextView: TextView by view(R.id.artistInformationTextView)
    private val artistIconImageView: ImageView by view(R.id.artistIconImageView)
    private val artistItemRootLayout: View by view(R.id.artistItemRootLayout)

    override fun bind(model: ArtistListItemModel, owner: LifecycleOwner) {
        artistNameTextView.text = model.title
        artistInformationTextView.text = model.information
        if (model.imageUri != null) {
            artistIconImageView.load(model.imageUri)
        }
        artistItemRootLayout.setOnClickListener { view ->
            onItemClicked(view, model.id)
        }
    }
}