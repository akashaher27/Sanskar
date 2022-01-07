package com.example.sanskar.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.view.recyclerview.BaseAdapter
import com.example.common.view.recyclerview.BaseViewHolder
import com.example.common.view.recyclerview.CustomRecyclerView
import com.example.common.view.recyclerview.Item
import com.example.sanskar.R

class FeaturesRvAdapter(list: List<ViewItem>) : BaseAdapter<ViewItem>(list) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ViewItem> {
        when (viewType) {
            ViewType.VIEW_TITLE -> {
                return FeaturesRVViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_rv_features_title, parent, false), this
                )
            }
            ViewType.VIEW_FEATURE -> {
                return FeaturesRVViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_feature_holder, parent, false), this
                )
            }
        }
        return FeaturesRVViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_feature_holder, parent, false), this
        )
    }


    override fun onBindViewHolder(holder: BaseViewHolder<ViewItem>, position: Int) {
        holder.bindData(baseList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return baseList[position].viewType
    }

    inner class FeaturesRVViewHolder(var view: View, adapter: FeaturesRvAdapter) :
        BaseViewHolder<ViewItem>(view, adapter) {

        private val title: TextView? = view.findViewById(R.id.tvTitle)
        private val featureHolder: CustomRecyclerView? = view.findViewById(R.id.rvFeature)

        override fun bindData(item: ViewItem) {
            when (item.viewType) {
                ViewType.VIEW_TITLE -> {
                    title?.text = (item as TitleModel).title
                }
                ViewType.VIEW_FEATURE -> {
                    val featureModel = item as FeatureModel
                    featureHolder?.layoutManager =
                        LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
                    featureHolder?.adapter = FeatureRvAdapter(featureModel.choices)
                }
            }
        }
    }
}

sealed class ViewItem(open var viewType: Int) : Item()

data class FeatureModel(
    override var viewType: Int = ViewType.VIEW_FEATURE,
    var choices: List<ChoiceModel>
) : ViewItem(viewType)

data class TitleModel(
    var title: String? = null,
    override var viewType: Int = ViewType.VIEW_TITLE
) : ViewItem(viewType)

class ViewType {
    companion object {
        const val VIEW_TITLE = 1
        const val VIEW_FEATURE = 2
    }
}