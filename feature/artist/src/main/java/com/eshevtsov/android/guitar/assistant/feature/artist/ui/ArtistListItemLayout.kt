package com.eshevtsov.android.guitar.assistant.feature.artist.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import coil.api.load
import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout
import com.eshevtsov.android.guitar.assistant.core.feature.view.view
import com.eshevtsov.android.guitar.assistant.feature.artist.domain.ArtistListItemModel
import com.eshevtsov.android.guitar.assistant.feature.artist.R

class ArtistListItemLayout(
    itemView: View
) : Layout<ArtistListItemModel>(itemView) {

    private val artistNameTextView: TextView by view(R.id.artistNameTextView)
    private val artistInformationTextView: TextView by view(R.id.artistInformationTextView)
    private val artistIconImageView: ImageView by view(R.id.artistIconImageView)

    override fun bind(model: ArtistListItemModel, owner: LifecycleOwner) {
        artistNameTextView.text = model.title
        artistInformationTextView.text = model.information
        if (model.imageUri != null) {
            artistIconImageView.load(model.imageUri)
        }
    }
}