package com.eshevtsov.android.guitar.assistant.core.feature.recycler

import androidx.recyclerview.widget.DiffUtil

/**
 * Allow to create [DiffUtil.Callback] object in more simple way.
 * Compare items by [Object.hashCode] to check if items content are the same and
 * by [UniqueParamSelector] to check if items are the same.
 *
 * _Note_: by default compare items by [Object.hashCode] to check if items content are the same.
 *
 * @author Evgeniy Shevtsov
 */
class DiffUtilCallback <in M : Any>(
    private val oldItems: List<M>,
    private val newItems: List<M>,
    private val idSelector: UniqueParamSelector<in M> = { it }
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItems.size
    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        idSelector(oldItems[oldItemPosition]) == idSelector(newItems[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition] == newItems[newItemPosition]
}

/**
 * Helps define a function that select unique param from object.
 */
typealias UniqueParamSelector<M> = (M) -> Any