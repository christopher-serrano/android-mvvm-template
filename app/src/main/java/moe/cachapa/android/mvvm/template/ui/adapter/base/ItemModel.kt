package moe.cachapa.android.mvvm.template.ui.adapter.base

import moe.cachapa.android.mvvm.template.ui.adapter.type.factory.BaseTypeFactory

abstract class ItemModel {
    abstract fun type(typeFactory: BaseTypeFactory): Int
}
