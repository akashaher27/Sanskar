package com.example.common.view.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.res.ResourcesCompat
import com.example.common.databinding.ViewCollapsingToolbarBinding

class CollapsingToolBar(context: Context, attributeSet: AttributeSet) :
    FrameLayout(context, attributeSet) {

    private var binding: ViewCollapsingToolbarBinding? = null

    init {
        initialiseView()
    }

    private fun initialiseView() {
        binding = ViewCollapsingToolbarBinding.inflate(LayoutInflater.from(context))
        addView(binding?.root)
    }

    fun setTitle(title: String) {
        binding?.tvTitle?.text = title
    }

    fun setToolbarBackground(backgroundId: Int) {
        binding?.ivBackground?.setImageResource(backgroundId)
    }
}