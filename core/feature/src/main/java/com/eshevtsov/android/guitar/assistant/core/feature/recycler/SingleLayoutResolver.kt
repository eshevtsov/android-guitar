package com.eshevtsov.android.guitar.assistant.core.feature.recycler

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.eshevtsov.android.guitar.assistant.core.feature.extension.inflate
import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout

/**
 * Implementation of [LayoutResolver] that allow to use [RecyclerView.Adapter]
 * with only one item type.
 *
 * @author Evgeniy Shevtsov
 */
class SingleLayoutResolver<in M : Any>(
    @LayoutRes
    val layoutRes: Int,
    private val construct: LayoutConstructor<M>
) : LayoutResolver<M> {

    /** Always return [layoutRes] field as item type. */
    override fun resolveType(position: Int, items: List<M>): Int = layoutRes

    /**
     * Uses [parent] to inflate view with layout [layoutRes]
     * and [construct] to create [Layout] object.
     */
    override fun createLayout(parent: ViewGroup, type: Int): Layout<M> =
        construct(parent.inflate(type))
}

/** [Layout] constructor function that create object. */
typealias LayoutConstructor<M> = (itemView: View) -> Layout<M>