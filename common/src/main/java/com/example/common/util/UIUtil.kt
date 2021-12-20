package com.example.common.util

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.text.Editable
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import android.graphics.drawable.Drawable
import android.widget.Toast


/**
 * Created by akash on 13,01,2021
 */

fun addFragment(holder: Int, fragManager: FragmentManager, fragment: Fragment, tag: String?) {
    fragManager.beginTransaction()
        .add(holder, fragment, tag)
        .addToBackStack(null)
        .commit()
}

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

fun View.hideKeyBoard() {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

fun getActionBarHeight(activity: Activity): Int {

    var actionBarHeight = 0
    var typeValue = TypedValue()
    try {
        if (activity.theme.resolveAttribute(android.R.attr.actionBarSize, typeValue, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(
                typeValue.data,
                activity.resources.displayMetrics
            )
        }
    } catch (e: Exception) {
    }
    return actionBarHeight
}

fun getFragmentManager(context: Context?): FragmentManager? {
    return when (context) {
        is AppCompatActivity -> context.supportFragmentManager
        is ContextThemeWrapper -> getFragmentManager(context.baseContext)
        else -> null
    }
}

fun getBitmapFromView(view: View): Bitmap {
    //Define a bitmap with the same size as the view
    val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
    //Bind a canvas to it
    val canvas = Canvas(returnedBitmap)
    //Get the view's background
    val bgDrawable = view.background
    if (bgDrawable != null)
    //has background drawable, then draw it on the canvas
        bgDrawable.draw(canvas)
    else
    //does not have background drawable, then draw white background on the canvas
        canvas.drawColor(Color.WHITE)
    // draw the view on the canvas
    view.draw(canvas)
    //return the bitmap
    return returnedBitmap
}

fun Context.showToast(msg: String)= Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()