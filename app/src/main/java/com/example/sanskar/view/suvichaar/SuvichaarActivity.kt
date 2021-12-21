package com.example.sanskar.view.suvichaar

import android.content.ContentValues
import android.content.Context
import android.content.Intent
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
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.view.get
import com.example.common.util.*
import com.example.common.util.FileManager.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.net.URI


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
            copySuvichaar()
        }
        binding?.edit?.setOnClickListener { }
        binding?.share?.setOnClickListener {
            showShareOption()
        }
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

    private fun copySuvichaar() {
        val value = binding?.background?.getTitle()
        value?.let {
            if (copyTextToClipboard(it, it)) {
                showToast(getString(R.string.msg_copy_image))
            }
        }
    }

    private fun showShareOption() {
        val b = getBitmapFromView(binding?.background!!)
        val uri = getTempFileUri(this, EXT_JPG)
        contentResolver.run {
            uri?.let {
                openOutputStream(it).use { out ->
                    b.compress(getBitmapFormat(ImageFormat.JPEG), 100, out)
                }
            }
        }

        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            type = getMimeType(Image(ImageFormat.JPEG))
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        showIntentChooser(intent)
    }
}