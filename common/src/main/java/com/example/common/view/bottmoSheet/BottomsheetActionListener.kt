package com.example.common.view.bottmoSheet

import android.view.View

/**
 * Created by akash on 06,10,2021
 */

interface BottomSheetStateListener {

    fun onStateChanged(bottomSheet: View, newState: Int)

    fun onSlide(bottomSheet: View, slideOffset: Float)
}

interface BottomSheetOnItemClickListener<T> {

    fun onItemClick(item:T)
}