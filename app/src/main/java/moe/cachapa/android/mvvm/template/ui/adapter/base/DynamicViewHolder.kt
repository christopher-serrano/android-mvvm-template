package moe.cachapa.android.mvvm.template.ui.adapter.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import moe.cachapa.android.mvvm.template.utils.ImageLoader

abstract class DynamicViewHolder<in T>(view: View, val imageLoader: ImageLoader) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T, position: Int, onClick: (ItemModel, String) -> Unit)
}
