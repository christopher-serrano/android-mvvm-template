package moe.cachapa.android.mvvm.template.ui.adapter.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import moe.cachapa.android.mvvm.template.ui.adapter.type.factory.BaseTypeFactory
import moe.cachapa.android.mvvm.template.utils.ImageLoader

class DynamicAdapter(
    private val typeFactory: BaseTypeFactory,
    items: List<ItemModel> = listOf(),
    private val imageLoader: ImageLoader,
    private val onClick: (ItemModel, String) -> Unit = { _, _ -> }
) : RecyclerView.Adapter<DynamicViewHolder<ItemModel>>() {

    var mItems: MutableList<ItemModel> = items.toMutableList()
    private var mDiffer: AsyncListDiffer<ItemModel>? = null
    private var mDiffCallback: DiffUtil.ItemCallback<ItemModel>? = null

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): DynamicViewHolder<ItemModel> {
        val view = LayoutInflater.from(parent.context).inflate(p1, parent, false)
        return typeFactory.holder(p1, view, imageLoader) as DynamicViewHolder<ItemModel>
    }

    fun setCallback(callback: DiffUtil.ItemCallback<ItemModel>) {
        mDiffCallback = callback
        mDiffer = AsyncListDiffer(this, mDiffCallback!!)
    }

    fun submitList(data: List<ItemModel>) {
        mItems = data.toMutableList()
        mDiffer?.submitList(mItems)
    }

    override fun getItemViewType(position: Int): Int {
        return mItems[position].type(typeFactory)
    }

    override fun getItemCount() = mItems.count()

    override fun onBindViewHolder(holder: DynamicViewHolder<ItemModel>, position: Int) {
        holder.bind(mItems[position], position, onClick)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<ItemModel>) {
        mItems.clear()
        mItems.addAll(list)
        notifyDataSetChanged()
    }

    fun insertAtPosition(list: List<ItemModel>, position: Int) {
        mItems.addAll(position, list)
        notifyItemRangeInserted(position, list.size)
        notifyItemChanged(list.size)
    }

    fun removeItems(list: List<ItemModel>) {
        val size = mItems.size
        mItems = list.toMutableList()
        notifyItemRangeRemoved(0, size)
    }

    /**
     * NOTE: To add dor remove items from an DynamicAdapter item list
     * the methods to use should be the ones present in this class. A transformation from model class
     * to ItemModel should be done in order to deal with the list.
     */
    @SuppressLint("NotifyDataSetChanged")
    fun removeItem(item: ItemModel) {
        mItems.remove(item)
        notifyDataSetChanged()
    }

    fun insertItem(item: ItemModel) {
        val pos = mItems.size
        mItems.add(item)
        notifyItemInserted(pos)
    }

    fun removeLastItem() {
        val item = mItems.last()
        val position = mItems.indexOf(item)
        mItems.removeLast()
        notifyItemRemoved(position)
    }

    fun clear() {
        val size = mItems.size
        mItems.clear()
        notifyItemRangeRemoved(0, size)
    }
}
