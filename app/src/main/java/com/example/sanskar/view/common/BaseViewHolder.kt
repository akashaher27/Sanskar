package com.example.sanskar.view.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by akash on 14,01,2021
 */
abstract class BaseViewHolder<T>(private val itemView: View):RecyclerView.ViewHolder(itemView) {

    abstract fun bindData(item:T)
}