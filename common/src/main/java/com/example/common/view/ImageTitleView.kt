package com.example.common.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.common.R
import com.example.common.databinding.ViewImageTitleBinding

/**
 * Created by akash on 15,11,2021
 */
class ImageTitleView(context: Context, var attributeSet: AttributeSet) :
    FrameLayout(context, attributeSet) {

    var binding: ViewImageTitleBinding? = null
    private lateinit var attr: TypedArray

    init {
        initialiseView()
    }

    private fun initialiseView() {
        binding = ViewImageTitleBinding.inflate(LayoutInflater.from(context))
        addView(binding?.root)

        attr = context.obtainStyledAttributes(attributeSet, R.styleable.ImageTitleView)
        var title = attr.getString(R.styleable.ImageTitleView_title)
        var icon = attr.getDrawable(R.styleable.ImageTitleView_icon)
        binding?.tvTitle?.text = title
        binding?.ivIcon?.setImageDrawable(icon)
    }
}
