package com.eshevtsov.android.guitar.assistant.feature.login.ui

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

object GoogleSignInExt {

    fun buildDefaultOptions(): GoogleSignInOptions =
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestId()
            .requestEmail()
            .build()

    fun buildClient(
        context: Context,
        options: GoogleSignInOptions = buildDefaultOptions()
    ): GoogleSignInClient =
        GoogleSignIn.getClient(context, options)

    class Contract(
        private val client: GoogleSignInClient
    ) : ActivityResultContract<Unit, GoogleSignInAccount?>() {
        override fun createIntent(context: Context, unit: Unit): Intent = client.signInIntent

        override fun parseResult(resultCode: Int, intent: Intent?): GoogleSignInAccount? =
            runCatching {
                GoogleSignIn.getSignedInAccountFromIntent(intent)
                    .getResult(ApiException::class.java)
            }.getOrNull()
    }
}