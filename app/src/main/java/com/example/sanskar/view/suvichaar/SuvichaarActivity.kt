package com.example.sanskar.view.suvichaar

import android.R.attr
import android.os.Bundle
import android.view.View
import com.example.common.view.bottmoSheet.Option
import com.example.sanskar.R
import com.example.sanskar.databinding.ActivitySuvichaarBinding
import com.example.sanskar.view.PostLoginActivity
import android.R.attr.label

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.example.common.util.copyTextToClipboard


class SuvichaarActivity() : PostLoginActivity() {


    private var binding: ActivitySuvichaarBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
        resetViewToInitialState()
    }

    private fun initialiseView() {
        binding = ActivitySuvichaarBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    private fun resetViewToInitialState() {
        setupListener()
    }

    private fun setupListener() {
        binding?.copy?.setOnClickListener {
            val value = binding?.background?.getTitle()
            value?.let {
                copyTextToClipboard(it, it)
            }
        }
    }

}