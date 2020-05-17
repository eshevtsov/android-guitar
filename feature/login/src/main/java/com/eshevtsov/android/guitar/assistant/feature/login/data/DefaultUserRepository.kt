package com.eshevtsov.android.guitar.assistant.feature.login.data

import com.eshevtsov.android.guitar.assistant.database.dao.UserDao
import com.eshevtsov.android.guitar.assistant.database.entity.UserEntity
import com.eshevtsov.android.guitar.assistant.feature.login.domain.UserModel
import com.eshevtsov.android.guitar.assistant.feature.login.domain.UserRepository
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.flow.take

class DefaultUserRepository(
    private val userDao: UserDao,
    private val userEntityToModel: UserEntityToModelMapper
) : UserRepository {

    override suspend fun create(
        googleTokenId: String,
        displayTitle: String?
    ): UserModel {
        val userEntity = UserEntity(googleTokenId, displayTitle)
        val generatedId = userDao.insert(userEntity)
        return userEntityToModel(userEntity.copy(id = generatedId))
    }

    override suspend fun get(googleTokenId: String): UserModel? {
        val userEntity = userDao.getByGoogleToken(googleTokenId)
            .take(1)
            .singleOrNull()
        return userEntity?.let(userEntityToModel::invoke)
    }

    override suspend fun get(id: Long): UserModel? {
        val userEntity = userDao.get(id)
            .take(1)
            .singleOrNull()
        return userEntity?.let(userEntityToModel::invoke)
    }
}