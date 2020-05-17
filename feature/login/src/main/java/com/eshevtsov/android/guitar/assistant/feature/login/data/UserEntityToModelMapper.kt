package com.eshevtsov.android.guitar.assistant.feature.login.data

import com.eshevtsov.android.guitar.assistant.database.entity.UserEntity
import com.eshevtsov.android.guitar.assistant.feature.login.domain.UserModel

interface UserEntityToModelMapper {
    operator fun invoke(userEntity: UserEntity): UserModel
}