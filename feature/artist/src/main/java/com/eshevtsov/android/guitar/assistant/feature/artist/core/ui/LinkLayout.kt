package com.eshevtsov.android.guitar.assistant.feature.artist.core.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import com.eshevtsov.android.guitar.assistant.core.feature.extension.openWebLink
import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout
import com.eshevtsov.android.guitar.assistant.core.feature.view.view
import com.eshevtsov.android.guitar.assistant.feature.artist.R
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.LinkModel

class LinkLayout(
    itemView: View
) : Layout<LinkModel>(itemView) {

    private val linkIconImageView: ImageView by view(R.id.linkIconImageView)
    private val linkTitleTextView: TextView by view(R.id.linkTitleTextView)
    private val linkRootLayout: View by view(R.id.linkRootLayout)

    override fun bind(model: LinkModel, owner: LifecycleOwner) {
        linkTitleTextView.setText(model.titleRes)
        linkIconImageView.setImageResource(model.iconRes)
        linkRootLayout.setOnClickListener { view -> view.context.openWebLink(model.value) }
    }
}