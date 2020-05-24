package com.eshevtsov.android.guitar.assistant.feature.artist.core.ui

import com.eshevtsov.android.guitar.assistant.feature.artist.R
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.LinkModel
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.LinkType

val LinkModel.iconRes: Int
    get() = this.type.iconRes

val LinkModel.titleRes: Int
    get() = this.type.titleRes

val LinkType.iconRes: Int
    get() = when(this) {
        LinkType.Facebook -> R.drawable.ic_facebook
        LinkType.Instagram -> R.drawable.ic_instagram
        LinkType.Twitter -> R.drawable.ic_twitter
        LinkType.Youtube -> R.drawable.ic_youtube
        LinkType.Unknown -> R.drawable.ic_link
    }

val LinkType.titleRes: Int
    get() = when(this) {
        LinkType.Facebook -> R.string.feature_artist__link_facebook
        LinkType.Instagram -> R.string.feature_artist__link_instagram
        LinkType.Twitter -> R.string.feature_artist__link_twitter
        LinkType.Youtube -> R.string.feature_artist__link_youtube
        LinkType.Unknown -> R.string.feature_artist__link_unknown
    }