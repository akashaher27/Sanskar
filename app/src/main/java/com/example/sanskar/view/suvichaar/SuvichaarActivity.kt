package com.example.sanskar.view.suvichaar

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.common.view.bottmoSheet.Option
import com.example.sanskar.R
import com.example.sanskar.databinding.ActivitySuvichaarBinding
import com.example.sanskar.view.PostLoginActivity
import android.graphics.drawable.Drawable

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.view.get
import com.example.common.util.FileManager.*
import com.example.common.util.copyTextToClipboard
import com.example.common.util.getBitmapFromView
import com.example.common.util.isDeviceSDKGreaterThan
import com.example.common.util.showToast
import java.io.FileNotFoundException


class SuvichaarActivity() : PostLoginActivity() {

    private val fileManager: FileManager by lazy {
        FileManagerImp(this)
    }
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
        binding?.save?.setOnClickListener {
            saveImageToGallery()
        }
        binding?.copy?.setOnClickListener {
            val value = binding?.background?.getTitle()
            value?.let {
                copyTextToClipboard(it, it)
            }
        }
        binding?.edit?.setOnClickListener { }
        binding?.share?.setOnClickListener { }
    }

    private fun saveImageToGallery() {
        if (fileManager.saveFileToSharedStorage(
                ImageFile(
                    "test",
                    getBitmapFromView(binding?.background!!),
                    ImageFormat.JPEG
                )
            )
        ) {
            showToast(getString(R.string.msg_save_image))
        }
    }
}