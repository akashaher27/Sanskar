package com.example.common.view.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by akash on 14,01,2021
 */
abstract class BaseViewHolder<T : Item>(var view: View, var adapter: BaseAdapter<T>) : RecyclerView.ViewHolder(view), View.OnClickListener {

    abstract fun bindData(item: T)

    override fun onClick(v: View?) {
        if (adapterPosition >= 0) {
            adapter.onItemClick(itemView.parent as RecyclerView, itemView, adapterPosition)
        }
    }

}