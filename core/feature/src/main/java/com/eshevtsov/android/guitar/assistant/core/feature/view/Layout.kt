package com.eshevtsov.android.guitar.assistant.core.feature.view

import android.view.View
import androidx.annotation.IdRes
import androidx.lifecycle.LifecycleOwner
import kotlinx.android.extensions.LayoutContainer

/**
 * Allow to reuse some view configurations logic and model data binding to this view.
 * Should perform all heavy [View.findViewById] in constructor or any initial method to
 * cash theirs as field or use Kotlin [containerView] for static imports.
 *
 * @author Evgeniy Shevtsov
 */
abstract class Layout<in M : Any>(
    itemView: View
) : LayoutContainer {

    override val containerView: View = itemView

    /**
     * Binds [model] data into [containerView] with [owner] lifecycle.
     */
    abstract fun bind(model: M, owner: LifecycleOwner)
}

/**
 * Simple implementation of [Layout] for empty view without need to [bind] model data.
 *
 * @author Evgeniy Shevtsov
 */
open class EmptyLayout(
    itemView: View
) : Layout<Unit>(itemView) {
    override fun bind(model: Unit, owner: LifecycleOwner) = Unit
}

inline fun <reified T : View, reified M : Any> Layout<M>.view(@IdRes viewIdRes: Int): Lazy<T> =
    lazy {
        this.containerView.findViewById(viewIdRes) as T
    }