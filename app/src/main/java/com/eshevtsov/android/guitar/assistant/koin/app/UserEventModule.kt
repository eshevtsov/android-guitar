package com.eshevtsov.android.guitar.assistant.koin.app

import com.eshevtsov.android.guitar.assistant.data.ClearAppPreferencesOnLogout
import com.eshevtsov.android.guitar.assistant.feature.login.domain.*
import org.koin.core.qualifier.named
import org.koin.dsl.module

object UserEventModule {
    val default = module {
        single<Set<OnLogin>>(named(LOGIN)) {
            setOf(
                SaveUserToPreferencesOnLogin(
                    get()
                )
            )
        }
        single(named(LOGOUT)) {
            setOf(
                GoogleSignOutOnLogout(
                    get()
                ),
                ClearAppPreferencesOnLogout(get())
            )
        }
        single<UserInteractor> {
            DefaultUserInteractor(
                get(),
                get(),
                get(),
                get(named(LOGIN)),
                get(named(LOGOUT))
            )
        }
    }
}

private const val LOGIN = "login"
private const val LOGOUT = "logout"