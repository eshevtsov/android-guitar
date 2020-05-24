package com.eshevtsov.android.guitar.assistant.koin.app

import com.eshevtsov.android.guitar.assistant.data.ClearAppPreferencesOnLogout
import com.eshevtsov.android.guitar.assistant.data.PrepopulateDemoDatabaseOnLogin
import com.eshevtsov.android.guitar.assistant.feature.login.domain.DefaultUserInteractor
import com.eshevtsov.android.guitar.assistant.feature.login.domain.GoogleSignOutOnLogout
import com.eshevtsov.android.guitar.assistant.feature.login.domain.SaveUserToPreferencesOnLogin
import com.eshevtsov.android.guitar.assistant.feature.login.domain.UserInteractor
import org.koin.core.qualifier.named
import org.koin.dsl.module

object UserEventModule {
    val default = module {
        single(named(LOGIN)) { setOf(
            PrepopulateDemoDatabaseOnLogin(get()),
            SaveUserToPreferencesOnLogin(get())
        ) }
        single(named(LOGOUT)) { setOf(
            GoogleSignOutOnLogout(get()),
            ClearAppPreferencesOnLogout(get())
        ) }
        single<UserInteractor> {
            DefaultUserInteractor(get(), get(), get(), get(named(LOGIN)), get(named(LOGOUT)))
        }
    }
}

private const val LOGIN = "login"
private const val LOGOUT = "logout"