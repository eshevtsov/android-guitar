package com.eshevtsov.android.guitar.assistant.core.feature.recycler

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout

/**
 * Base [RecyclerView.Adapter] implementation.
 * Uses [resolver] to resolve view type and create [Layout] for [RecyclerViewHolder].
 * Uses [uniqueParam] to update items with [DiffUtil.Callback].
 *
 * @author Evgeniy Shevtsov
 */
@Suppress("UNCHECKED_CAST")
open class RecyclerAdapter<M : Any, VH : RecyclerViewHolder<M>>
@JvmOverloads constructor(
    protected val resolver: LayoutResolver<M>,
    items: List<M> = listOf(),
    protected var uniqueParam: UniqueParamSelector<M> = { it },
    protected val createViewHolder: ViewHolderCreator<M, VH> = { RecyclerViewHolder(it) as VH }
) : RecyclerView.Adapter<VH>() {

    protected var items: MutableList<M> = mutableListOf<M>().apply { addAll(items) }

    /** Syntactic sugar constructor to create [RecyclerAdapter] in a simpler way. */
    constructor(
        @LayoutRes layoutRes: Int,
        createLayout: (itemView: View) -> Layout<M>,
        items: List<M> = listOf(),
        uniqueParam: UniqueParamSelector<M> = { it },
        createViewHolder: ViewHolderCreator<M, VH> = { RecyclerViewHolder(it) as VH }
    ) : this(SingleLayoutResolver(layoutRes, createLayout), items, uniqueParam, createViewHolder)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layout = resolver.createLayout(parent, viewType)
        return createViewHolder.invoke(layout)
    }

    override fun onBindViewHolder(holderRecycler: VH, position: Int) {
        holderRecycler.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
    override fun getItemViewType(position: Int): Int = resolver.resolveType(position, items)

    override fun onViewAttachedToWindow(holder: VH) {
        super.onViewAttachedToWindow(holder)
        holder.onAttach()
    }

    override fun onViewDetachedFromWindow(holder: VH) {
        holder.onDetach()
        super.onViewDetachedFromWindow(holder)
    }

    open fun updateItems(items: List<M>, useDiffUtil: Boolean = true) {
        val mutableItems = ArrayList(items)
        if (useDiffUtil) {
            val callback = DiffUtilCallback(this.items, mutableItems, uniqueParam)
            val diffResult = DiffUtil.calculateDiff(callback, true)

            this.items = mutableItems
            diffResult.dispatchUpdatesTo(this)
        } else {
            this.items = mutableItems
            notifyDataSetChanged()
        }
    }
}