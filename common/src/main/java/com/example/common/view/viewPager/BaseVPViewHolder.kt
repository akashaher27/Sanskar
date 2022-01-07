package com.example.common.view.viewPager

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by akash on 14,01,2021
 */
abstract class BaseVPViewHolder<T : VPItem>(view: View, adapter: BaseVPAdapter<T>) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    private var dataAdapter: BaseVPAdapter<T> = adapter
    abstract fun bindData(item: T)

    override fun onClick(v: View?) {
        if (adapterPosition >= 0) {
            dataAdapter.onItemClick(itemView.parent as RecyclerView, itemView, adapterPosition)
        }
    }

}