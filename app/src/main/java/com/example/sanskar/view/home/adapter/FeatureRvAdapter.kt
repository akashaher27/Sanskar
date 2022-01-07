package com.example.sanskar.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.common.view.recyclerview.BaseAdapter
import com.example.common.view.recyclerview.BaseViewHolder
import com.example.common.view.recyclerview.Item
import com.example.sanskar.R

class FeatureRvAdapter(list: List<ChoiceModel>) : BaseAdapter<ChoiceModel>(list) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ChoiceModel> {
        return FeatureViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_feature, parent, false),
            this
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ChoiceModel>, position: Int) {
        holder.bindData(baseList[position])
    }

    inner class FeatureViewHolder(view: View, adapter: FeatureRvAdapter) :
        BaseViewHolder<ChoiceModel>(view, adapter) {

        private val choiceLabel: TextView? = view.findViewById(R.id.tvChoiceLabel)
        override fun bindData(item: ChoiceModel) {
            choiceLabel?.text = item.title
        }
    }
}

data class ChoiceModel(
    var title: String
) : Item()