package com.example.baseproject.view.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by akash on 13,01,2021
 */

fun addFragment(holder: Int, fragManager: FragmentManager, fragment: Fragment, tag: String?) {
    fragManager.beginTransaction()
        .add(holder, fragment, tag)
        .addToBackStack(null)
        .commit()
}