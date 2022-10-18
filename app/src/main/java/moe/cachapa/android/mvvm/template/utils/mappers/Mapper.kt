package moe.cachapa.android.mvvm.template.utils.mappers

interface Mapper<T, R> {
    fun map(input: T): R
}