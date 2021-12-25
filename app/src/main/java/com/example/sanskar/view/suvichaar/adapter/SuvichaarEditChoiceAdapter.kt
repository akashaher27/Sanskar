package com.example.sanskar.view.suvichaar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.view.recyclerview.BaseAdapter
import com.example.common.view.recyclerview.BaseViewHolder
import com.example.common.view.recyclerview.Item
import com.example.sanskar.R

class SuvichaarEditChoiceAdapter(itemList: MutableList<ViewItem>) :
    BaseAdapter<ViewItem>(itemList) {

    interface EditChoiceItemClickListener {
        fun onClickBackground(backgroundModel: BackgroundModel?)
        fun onClickFont(fontModel: FontModel?)
    }

    private var itemClickHandler: EditChoiceItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewItem> {
        when (viewType) {

            ViewType.VIEW_TITLE -> {
                return SuvichaarEditChoiceViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_rv_title, parent, false), this
                )
            }
            ViewType.VIEW_BACKGROUND -> {
                return SuvichaarEditChoiceViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_suvichaar_background_holder, parent, false), this
                )

            }
            ViewType.VIEW_FONT -> {
                return SuvichaarEditChoiceViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_suvichaar_background, parent, false), this
                )
            }
            else -> {
                return SuvichaarEditChoiceViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_suvichaar_background, parent, false), this
                )
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewItem>, position: Int) {
        holder.bindData(baseList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return baseList[position].viewType
    }

    fun setEditChoiceItemClickListener(handler: EditChoiceItemClickListener) {
        itemClickHandler = handler
    }

    inner class SuvichaarEditChoiceViewHolder(var view: View, adapter: SuvichaarEditChoiceAdapter) :
        BaseViewHolder<ViewItem>(view, adapter) {

        private val title: TextView? = view.findViewById(R.id.tvTitle)
        private val rvBackgroundHolder: RecyclerView? = view.findViewById(R.id.rvBackgroundHolder)
        override fun bindData(item: ViewItem) {
            when (item.viewType) {
                ViewType.VIEW_TITLE -> {
                    val viewTitle = item as TitleModel
                    title?.text = viewTitle.title
                }
                ViewType.VIEW_BACKGROUND -> {
                    val viewBackground = item as BackgroundHolderModel
                    rvBackgroundHolder?.layoutManager =
                        LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
                    val adapter = SuvichaarBackgroundAdapter(viewBackground.backgroundHolder)
                    adapter.setItemClickListener { parent, view, position ->
                        itemClickHandler?.onClickBackground(adapter.getItemAt(position))
                    }
                    rvBackgroundHolder?.adapter = adapter
                }
                ViewType.VIEW_FONT -> { }
            }
        }
    }
}


sealed class ViewItem(
    open var viewType: Int
) : Item()

data class BackgroundHolderModel(
    var backgroundHolder: MutableList<BackgroundModel>,
    override var viewType: Int = ViewType.VIEW_BACKGROUND
) : ViewItem(viewType)

data class BackgroundModel(
    @DrawableRes
    var backgroundId: Int,
) : Item()

data class FontHolderModel(
    var fontHolder: MutableList<FontModel>,
    override var viewType: Int = ViewType.VIEW_FONT
) : ViewItem(viewType)

data class FontModel(
    var font: String,
)

data class TitleModel(
    var title: String,
    override var viewType: Int = ViewType.VIEW_TITLE
) : ViewItem(viewType)

class ViewType() {
    companion object {
        const val VIEW_BACKGROUND = 1
        const val VIEW_FONT = 2
        const val VIEW_TITLE = 3
    }
}
