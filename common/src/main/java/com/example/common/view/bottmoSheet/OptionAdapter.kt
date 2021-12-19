package com.example.common.view.bottmoSheet

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.example.common.R
import com.example.common.view.recyclerview.BaseAdapter
import com.example.common.view.recyclerview.BaseViewHolder
import com.example.common.view.recyclerview.Item
import kotlinx.android.parcel.Parcelize


/**
 * Created by akash on 06,09,2021
 */
class OptionAdapter(options: MutableList<Option>) :
    BaseAdapter<Option>(options){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Option> {
        return OptionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_option, parent, false), this
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Option>, position: Int) {
        var viewholder = holder as OptionViewHolder
        viewholder.bindData(baseList[position])
    }
}

class OptionViewHolder(view: View, adapter: OptionAdapter) : BaseViewHolder<Option>(view, adapter){
    private var label = view.findViewById(R.id.tvLabel) as TextView
    private var icon  = view.findViewById(R.id.ivIcon) as ImageView

    init {
        view.setOnClickListener(this)
    }

    override fun bindData(item: Option) {
        label.isSelected = item.isSelected
        label.text = item.label
        item.icon?.let {

        }
    }

}

@Parcelize
data class Option(
    var label: String,
    var id: Int? = null,
    @DrawableRes
    var icon: Int? = null,
    var isSelected: Boolean = false
) : Item(),Parcelable