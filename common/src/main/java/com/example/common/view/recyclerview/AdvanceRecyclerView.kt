package com.example.common.view.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.view.isNotEmpty
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.common.R
import kotlinx.android.synthetic.main.advance_recycler_view.view.*

/**
 * Created by akash on 29,04,2021
 */
class AdvanceRecyclerView : FrameLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        View.inflate(context, R.layout.advance_recycler_view, this)
        recyclerView.visibility = View.GONE
        errorViewHolder.visibility = View.GONE
    }

    fun initRecyclerView(callback: (recyclerView: CustomRecyclerView) -> Unit) {
        recyclerView.adapter?.unregisterAdapterDataObserver(mDataObserver)
        callback(recyclerView)
        updateErrorView()
        recyclerView.adapter?.registerAdapterDataObserver(mDataObserver)
    }

    fun addErrorView(errorView: LinearLayout) {
        if (errorViewHolder.isNotEmpty()) {
            errorViewHolder.removeAllViews()
        }
        errorViewHolder.addView(errorView)
    }

    private fun updateErrorView() {
        val showErrorView = recyclerView.adapter?.let {
            it.itemCount == 0
        } ?: true
        errorViewHolder.isVisible = showErrorView
        recyclerView.isVisible = !showErrorView
    }

    private val mDataObserver: RecyclerView.AdapterDataObserver =
        object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                super.onChanged()
                updateErrorView()

            }

            override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                super.onItemRangeChanged(positionStart, itemCount)
                updateErrorView()
            }

            override fun onItemRangeChanged(
                positionStart: Int,
                itemCount: Int,
                payload: Any?
            ) {
                super.onItemRangeChanged(positionStart, itemCount, payload)
                updateErrorView()
            }

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                updateErrorView()
            }

            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                super.onItemRangeRemoved(positionStart, itemCount)
                updateErrorView()
            }

        }
}