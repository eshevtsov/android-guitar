package com.eshevtsov.android.guitar.assistant.core.feature.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout

/**
 * Allow [RecyclerView.Adapter] to resolve item type and create [Layout] for this type.
 *
 * @author Evgeniy Shevtsov
 */
interface LayoutResolver<in M : Any> {

    /**
     * Create and return [Layout] for specific [type] and [parent].
     * Can be used in [RecyclerView.Adapter.onCreateViewHolder] to create layout object,
     * that than will be passed into [RecyclerView.ViewHolder] as field.
     */
    fun createLayout(parent: ViewGroup, type: Int): Layout<M>

    /**
     * Resolve item type for specific [position] - index in [items] list, and return it.
     * Can be used in [RecyclerView.Adapter.getItemViewType].
     */
    fun resolveType(position: Int, items: List<M>): Int
}