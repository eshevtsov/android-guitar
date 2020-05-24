package com.eshevtsov.android.guitar.assistant.core.feature.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(
    @LayoutRes layoutResId: Int,
    attachToParent: Boolean = false
): View =
    LayoutInflater.from(context).inflate(layoutResId, this, attachToParent)