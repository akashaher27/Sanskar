package com.example.common.view.customView

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
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
        val shapeModel = ShapeAppearanceModel
            .builder()
            .setAllCorners(
                CornerFamily.ROUNDED,
                resources.getDimension(R.dimen.radius_largeComponent)
            )
            .build()
        shapeAppearanceModel = shapeModel
    }

    private fun populateView() {
        changeBackgroundView()
    }

    private fun changeBackgroundView() {

    }

    fun getTitle(): String {
        return binding?.tvTitle?.text.toString()
    }

    fun updateBackground(drawable: Int?) {
        drawable?.let {
            binding?.clBackground?.background = ResourcesCompat.getDrawable(resources, it, null)
        }
    }

}