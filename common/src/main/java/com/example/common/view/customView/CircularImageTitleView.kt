package com.example.common.view.customView

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.common.R
import com.example.common.databinding.ViewCircularImageTitleBinding


class CircularImageTitleView(context: Context, private val attributeSet: AttributeSet) :
    FrameLayout(context, attributeSet) {

    private var binding: ViewCircularImageTitleBinding? = null
    private lateinit var attr: TypedArray

    init {
        initialiseView()
    }

    private fun initialiseView() {
        binding = ViewCircularImageTitleBinding.inflate(LayoutInflater.from(context))
        addView(binding?.root)

        attr = context.obtainStyledAttributes(attributeSet, R.styleable.ImageTitleView)
        val title = attr.getString(R.styleable.ImageTitleView_title)
        val icon = attr.getDrawable(R.styleable.ImageTitleView_icon)
        binding?.tvTitle?.text = title
        binding?.ivIcon?.setImageDrawable(icon)
    }

}