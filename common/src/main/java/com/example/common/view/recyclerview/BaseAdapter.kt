package com.example.common.view.recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by akash on 14,01,2021
 */
abstract class BaseAdapter<T : Item>(list: MutableList<T>) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    protected var baseList: MutableList<T> = list
    private var listener: OnRecyclerViewOnItemClickListener? = null

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T>

    abstract override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int)

    override fun getItemCount(): Int {
        return baseList.size
    }

    fun addItems(list: List<T>) {
        baseList.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(item: T) {
        baseList.add(item)
        notifyItemInserted(baseList.size)
    }

    fun removeItem(position: Int) {
        baseList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun removeItem(item: T) {
        baseList.indexOf(item).let {
            if (it != -1) {
                baseList.remove(item)
                notifyItemRemoved(it)
            }
        }
    }

    fun clearData() {
        baseList.clear()
        notifyDataSetChanged()
    }

    fun setItemClickListener(listener:OnRecyclerViewOnItemClickListener) {
        this.listener = listener
    }

    fun onItemClick(parent: RecyclerView, view: View, position: Int) {
        listener?.onItemClick(parent, view, position)
    }

    fun getItemAt(index: Int): T? {
        var item: T? = null
        if (index >= 0) {
            item = baseList[index]
        }
        return item
    }

}