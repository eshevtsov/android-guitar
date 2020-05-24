package com.eshevtsov.android.guitar.assistant.feature.artist.core.data

import com.eshevtsov.android.guitar.assistant.database.entity.LinkEntity
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.LinkModel
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.LinkType

class DefaultLinkEntityToModelMapper : LinkEntityToModelMapper {
    override operator fun invoke(entity: LinkEntity) =
        LinkModel(
            value = entity.value,
            type = when (entity.type) {
                LinkEntity.Type.Youtube -> LinkType.Youtube
                LinkEntity.Type.Twitter -> LinkType.Twitter
                LinkEntity.Type.Instagram -> LinkType.Instagram
                LinkEntity.Type.Facebook -> LinkType.Facebook
                LinkEntity.Type.Unknown -> LinkType.Unknown
            }
        )
}