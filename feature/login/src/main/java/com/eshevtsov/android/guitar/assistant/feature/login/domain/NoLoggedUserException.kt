package com.eshevtsov.android.guitar.assistant.feature.login.domain

class NoLoggedUserException
    : IllegalStateException("There's no logged user, login page should be called.")