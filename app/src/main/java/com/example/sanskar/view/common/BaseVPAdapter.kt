package com.example.sanskar.view.common

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by akash on 01,02,2021
 */
abstract class BaseVPAdapter<T,P: BaseVPViewHolder>(val list:List<T>):RecyclerView.Adapter<P>(){

    override fun getItemCount(): Int {
        return list.size
    }
}