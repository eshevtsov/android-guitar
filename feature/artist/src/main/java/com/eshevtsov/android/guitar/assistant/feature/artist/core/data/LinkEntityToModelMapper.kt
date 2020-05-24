package com.eshevtsov.android.guitar.assistant.feature.artist.core.data

import com.eshevtsov.android.guitar.assistant.database.entity.LinkEntity
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.LinkModel

interface LinkEntityToModelMapper {
    operator fun invoke(entity: LinkEntity): LinkModel
}