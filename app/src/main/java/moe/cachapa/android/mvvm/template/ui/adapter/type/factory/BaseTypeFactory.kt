package moe.cachapa.android.mvvm.template.ui.adapter.type.factory

import android.view.View
import moe.cachapa.android.mvvm.template.ui.adapter.base.DynamicViewHolder
import moe.cachapa.android.mvvm.template.utils.ImageLoader

interface BaseTypeFactory {
    fun holder(type: Int, view: View, imageLoader: ImageLoader): DynamicViewHolder<*>
}