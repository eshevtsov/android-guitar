package com.eshevtsov.android.guitar.assistant.feature.login.data

import com.eshevtsov.android.guitar.assistant.database.entity.UserEntity
import com.eshevtsov.android.guitar.assistant.feature.login.domain.UserModel

class DefaultUserEntityToModelMapper : UserEntityToModelMapper {

    override operator fun invoke(userEntity: UserEntity) =
        UserModel(
            id = userEntity.id,
            googleTokenId = userEntity.googleTokenId,
            displayTitle = userEntity.displayTitle
        )
}