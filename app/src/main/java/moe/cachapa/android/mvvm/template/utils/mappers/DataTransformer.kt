package moe.cachapa.android.mvvm.template.utils.mappers

interface DataTransformer<F, T> {
    fun transform(from: F): T
    fun transform(from: Collection<F>): Collection<T>
}
