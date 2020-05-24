package com.eshevtsov.android.guitar.assistant.core.feature.recycler

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout

/**
 * Simple implementation of [RecyclerView.ViewHolder] with it's own lifecycle
 * and [Layout] object as internal view holding and binding implementation.
 *
 * @author Evgeniy Shevtsov
 */
open class RecyclerViewHolder<M : Any>(
    protected val layout: Layout<M>
) : RecyclerView.ViewHolder(layout.containerView), LifecycleOwner {

    protected val lifecycleRegistry = LifecycleRegistry(this)
    protected var model: M? = null

    init {
        lifecycleRegistry.currentState = Lifecycle.State.INITIALIZED
    }

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    /**
     * Called in [RecyclerView.Adapter.onViewAttachedToWindow] when view is attached to window.
     * Signals that view lifecycle is resumed and binds [model] data to [layout].
     */
    open fun onAttach() {
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
        lifecycleRegistry.currentState = Lifecycle.State.STARTED
        lifecycleRegistry.currentState = Lifecycle.State.RESUMED

        model?.let {
            layout.bind(it, this)
        }
    }

    /**
     * Called in [RecyclerView.Adapter.onViewDetachedFromWindow] when view is detached from window.
     * Signals that view lifecycle is destroyed.
     */
    open fun onDetach() {
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

    /**
     * Save [model] to this [RecyclerViewHolder.model] object field.
     *
     * _Note_: this function don't bind [model] to [layout] directly.
     */
    open fun bind(model: M) {
        this.model = model
    }
}