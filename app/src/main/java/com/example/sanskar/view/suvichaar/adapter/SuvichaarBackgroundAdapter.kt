package com.example.sanskar.view.suvichaar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.example.common.view.recyclerview.BaseAdapter
import com.example.common.view.recyclerview.BaseViewHolder
import com.example.sanskar.R
import com.google.android.material.imageview.ShapeableImageView

class SuvichaarBackgroundAdapter(items: MutableList<BackgroundModel>) :
    BaseAdapter<BackgroundModel>(items) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<BackgroundModel> {
        return SuvichaarBackgroundViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_suvichaar_background, parent, false), this
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BackgroundModel>, position: Int) {
        holder.bindData(baseList[position])
    }
}

class SuvichaarBackgroundViewHolder(view: View, adapter: SuvichaarBackgroundAdapter) :
    BaseViewHolder<BackgroundModel>(view, adapter) {

    private var background: ShapeableImageView? = view.findViewById(R.id.ivBackground)
    var context: Context = view.context

    init {
        view.setOnClickListener(this)
    }

    override fun bindData(item: BackgroundModel) {
        background?.background =
            ResourcesCompat.getDrawable(context.resources, item.backgroundId, null)
    }

}