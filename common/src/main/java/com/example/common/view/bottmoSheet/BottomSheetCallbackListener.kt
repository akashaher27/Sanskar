package com.example.common.view.bottmoSheet

import android.view.View

/**
 * Created by akash on 27,09,2021
 */
interface BottomSheetCallbackListener {

    fun onStateChanged(bottomSheet: View, newState: Int)

    fun onSlide(bottomSheet: View, slideOffset: Float)
}