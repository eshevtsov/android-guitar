package com.eshevtsov.android.guitar.assistant.koin.feature

import com.eshevtsov.android.guitar.assistant.feature.login.data.DefaultLoggedUserPreferences
import com.eshevtsov.android.guitar.assistant.feature.login.data.DefaultUserEntityToModelMapper
import com.eshevtsov.android.guitar.assistant.feature.login.data.DefaultUserRepository
import com.eshevtsov.android.guitar.assistant.feature.login.data.UserEntityToModelMapper
import com.eshevtsov.android.guitar.assistant.feature.login.domain.Authenticator
import com.eshevtsov.android.guitar.assistant.feature.login.domain.DefaultAuthenticator
import com.eshevtsov.android.guitar.assistant.feature.login.domain.LoggedUserPreferences
import com.eshevtsov.android.guitar.assistant.feature.login.domain.UserRepository
import com.eshevtsov.android.guitar.assistant.feature.login.ui.DefaultLoginViewModel
import com.eshevtsov.android.guitar.assistant.feature.login.ui.GoogleSignInExt
import com.eshevtsov.android.guitar.assistant.feature.login.ui.LoginFragment
import com.eshevtsov.android.guitar.assistant.feature.login.ui.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LoginModule {
    val default = module {
        single { GoogleSignInExt.buildClient(androidContext()) }
        single { GoogleSignInExt.Contract(get()) }
        single<LoggedUserPreferences> { DefaultLoggedUserPreferences(get()) }
        single<Authenticator> { DefaultAuthenticator() }
        single<UserEntityToModelMapper> { DefaultUserEntityToModelMapper() }
        single<UserRepository> { DefaultUserRepository(get(), get()) }
        viewModel<LoginViewModel> { DefaultLoginViewModel(get()) }
        fragment { LoginFragment(get(), get(), get()) }
    }
}