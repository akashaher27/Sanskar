package com.example.sanskar.view.common

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by akash on 14,01,2021
 */
abstract class BaseAdapter<T, P : BaseViewHolder<T>>(private val list: List<T>) : RecyclerView.Adapter<P>() {

    override fun getItemCount(): Int {
        return list.size
    }

}