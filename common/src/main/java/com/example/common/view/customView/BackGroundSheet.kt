package com.example.common.view.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.cardview.widget.CardView
import com.example.common.R
import com.example.common.databinding.ViewBackgroundSheetBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel
import java.util.jar.Attributes

class BackGroundSheet(context: Context, attributes: AttributeSet) :
    MaterialCardView(context, attributes) {

    private var binding: ViewBackgroundSheetBinding? = null

    init {
        initialiseView()
        populateView()
    }

    private fun initialiseView() {
        binding = ViewBackgroundSheetBinding.inflate(LayoutInflater.from(context))
        addView(binding?.root)
    }

    private fun populateView() {
        changeBackgroundView()
    }

    private fun changeBackgroundView() {

    }

    private fun changeShape() {
        val shapeModel = ShapeAppearanceModel
            .builder()
            .setAllCorners(CornerFamily.ROUNDED, 80F)
            .build()
        shapeAppearanceModel = shapeModel
    }

    fun getTitle():String{
        return binding?.tvTitle?.text.toString()
    }

}