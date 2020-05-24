package com.eshevtsov.android.guitar.assistant.core.feature.extension

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.openWebLink(webLink: String) {
    startActivity(
        Intent(Intent.ACTION_VIEW, Uri.parse(webLink))
    )
}