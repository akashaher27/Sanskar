package com.example.common.view.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.example.common.R

/**
 * Created by akash on 01,05,2021
 */
class EmptyErrorView:LinearLayout {

    constructor(context: Context) :super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        View.inflate(context, R.layout.empty_error_view, this)
    }
}