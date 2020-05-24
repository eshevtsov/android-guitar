package com.eshevtsov.android.guitar.assistant.core.feature.resource

import android.content.res.Resources
import com.eshevtsov.android.guitar.assistant.core.feature.R

class AndroidStringProvider(
    private val resources: Resources
) : StringProvider {

    override fun artistListItemInformation(albumsCount: Long, songsCount: Long): String =
        resources.getString(
            R.string.feature_artist__list_item_information,
            albumsCount.toString(),
            songsCount.toString()
        )
}