package com.example.sanskar.view.suvichaar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.common.view.recyclerview.BaseAdapter
import com.example.common.view.recyclerview.BaseViewHolder
import com.example.sanskar.R


class SuvichaarFontAdapter(items: MutableList<FontModel>) : BaseAdapter<FontModel>(items) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<FontModel> {
        return SuvichaarFontViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_suvichaar_font, parent, false), this
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<FontModel>, position: Int) {
        holder.bindData(baseList[position])
    }

    inner class SuvichaarFontViewHolder(view: View, adapter: SuvichaarFontAdapter) :
        BaseViewHolder<FontModel>(view, adapter) {
        private val title: TextView? = view.findViewById(R.id.tvTitle)

        init {
            view.setOnClickListener(this)
        }

        override fun bindData(item: FontModel) {
            when (item.font) {
                Font.FONT_BABY -> {
                    title?.setTextAppearance(R.style.TextAppearance_Ooohbabyregular)
                }
                Font.FONT_FUZZY -> {
                    title?.setTextAppearance(R.style.TextAppearance_Fuzzybubblesregular)
                }
                Font.FONT_INDIE -> {
                    title?.setTextAppearance(R.style.TextAppearance_Indieflowerregular)
                }
                Font.FONT_MOOL -> {
                    title?.setTextAppearance(R.style.TextAppearance_Moolahlahregular)
                }
                Font.FONT_SHIZU -> {
                    title?.setTextAppearance(R.style.TextAppearance_Shizurueegular)
                }
                Font.FONT_PACIF -> {
                    title?.setTextAppearance(R.style.TextAppearance_Pacificoregular)
                }
                Font.FONT_TWINK -> {
                    title?.setTextAppearance(R.style.TextAppearance_twinklestarregular)
                }
            }

        }

    }
}