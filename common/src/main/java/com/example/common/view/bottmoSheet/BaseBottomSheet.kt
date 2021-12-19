package com.example.common.view.bottmoSheet

import android.app.Dialog
import android.os.Bundle
import android.view.View
import com.example.common.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by akash on 27,09,2021
 */
open class BaseBottomSheet() : BottomSheetDialogFragment() {

    private var bottomSheetStateListener: BottomSheetStateListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var dialog = super.onCreateDialog(savedInstanceState)
        if (dialog is BottomSheetDialog) {
            dialog.behavior.addBottomSheetCallback(bottomSheetStateListener())
        }
        return dialog
    }

    private fun bottomSheetStateListener() = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            bottomSheetStateListener?.onStateChanged(bottomSheet, newState)
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            bottomSheetStateListener?.onSlide(bottomSheet, slideOffset)
        }
    }

    fun setupBottomSheetStateListener(listener: BottomSheetStateListener) {
        bottomSheetStateListener = listener
    }

    override fun getTheme(): Int {
        return R.style.Style_BottomSheet_Modal_Choices
    }

    fun dismissBottomSheet(){
        dismiss()
    }
}