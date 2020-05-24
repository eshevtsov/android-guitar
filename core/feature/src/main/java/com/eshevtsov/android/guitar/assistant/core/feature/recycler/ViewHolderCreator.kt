package com.eshevtsov.android.guitar.assistant.core.feature.recycler

import com.eshevtsov.android.guitar.assistant.core.feature.view.Layout

/**
 * Used in [RecyclerAdapter] to create [RecyclerViewHolder] object or it's subtypes. Use
 * this class to create and use subtype of [RecyclerViewHolder], if you need custom logic
 * and base view holder isn't enough.
 *
 * @author Evgeniy Shevtsov
 */
typealias ViewHolderCreator<M, VH> = (layout: Layout<M>) -> VH