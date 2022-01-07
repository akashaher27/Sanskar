package com.example.sanskar.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.view.viewPager.BaseVPAdapter
import com.example.common.view.viewPager.BaseVPViewHolder
import com.example.common.view.viewPager.VPItem
import com.example.sanskar.R

class BannerVpAdapter(list: MutableList<BannerModel>) : BaseVPAdapter<BannerModel>(list) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseVPViewHolder<BannerModel> {
        return BannerVPViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_banner_holder, parent, false), this
        )
    }

    override fun onBindViewHolder(holder: BaseVPViewHolder<BannerModel>, position: Int) {
        holder.bindData(baseList[position])
    }


    inner class BannerVPViewHolder(view: View, adapter: BannerVpAdapter) :
        BaseVPViewHolder<BannerModel>(view, adapter) {

        override fun bindData(item: BannerModel) {

        }
    }
}

data class BannerModel(
    var flag: Boolean = false
) : VPItem()