package com.example.sanskar.view.suvichaar.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import com.example.common.view.recyclerview.BaseAdapter
import com.example.common.view.recyclerview.BaseViewHolder
import com.example.common.view.recyclerview.Item
import com.example.sanskar.R
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView

class SuvichaarListAdapter(list: MutableList<SuvichaarItemModel>) :
    BaseAdapter<SuvichaarItemModel>(list) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<SuvichaarItemModel> {
        return SuvichaarListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_suvichaar, parent, false),
            this
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<SuvichaarItemModel>, position: Int) {
        holder.bindData(baseList[position])
    }


    inner class SuvichaarListViewHolder(view: View, adapter: SuvichaarListAdapter) :
        BaseViewHolder<SuvichaarItemModel>(view, adapter) {

        val suvichaarTitle: TextView = view.findViewById(R.id.tvSuvichaar)
        val background: ShapeableImageView = view.findViewById(R.id.ivBackground)
        val context: Context = view.context

        override fun bindData(item: SuvichaarItemModel) {
            suvichaarTitle.text = item.suvichaarTitle
            background.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    item.backGroundId,
                    null
                )
            )
        }
    }
}

data class SuvichaarItemModel(
    var suvichaarTitle: String,
    @DrawableRes
    var backGroundId: Int
) : Item()