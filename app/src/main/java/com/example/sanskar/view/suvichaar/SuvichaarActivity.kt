package com.example.sanskar.view.suvichaar

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.sanskar.R
import com.example.sanskar.databinding.ActivitySuvichaarBinding
import com.example.sanskar.view.PostLoginActivity

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.util.*
import com.example.common.util.FileManager.*
import com.example.sanskar.view.suvichaar.adapter.*
import com.google.android.material.bottomsheet.BottomSheetBehavior


class SuvichaarActivity() : PostLoginActivity() {

    private val fileManager: FileManager by lazy {
        FileManagerImp(this)
    }
    private var binding: ActivitySuvichaarBinding? = null
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
        resetViewToInitialState()
    }

    private fun initialiseView() {
        binding = ActivitySuvichaarBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initBottomSheet()
        initEditChoices()
    }

    private fun initEditChoices() {
        binding?.rvChoices?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val list = mutableListOf<ViewItem>()
        list.add(TitleModel(getString(R.string.title_background)))
        val backgroundHolder = mutableListOf<BackgroundModel>()
        val backgroundList = resources.obtainTypedArray(R.array.background)
        for (i in 0 until backgroundList.length()) {
            val id: Int = backgroundList.getResourceId(i, -1)
            backgroundHolder.add(BackgroundModel(id))
        }
        backgroundList.recycle()
        list.add(BackgroundHolderModel(backgroundHolder))

        list.add(TitleModel(getString(R.string.title_font)))
        val fontHolder = mutableListOf<FontModel>()
        val p = mutableListOf(
            Font.FONT_TWINK,
            Font.FONT_PACIF,
            Font.FONT_SHIZU,
            Font.FONT_MOOL,
            Font.FONT_INDIE,
            Font.FONT_FUZZY,
            Font.FONT_BABY
        )
        p.forEach {
            fontHolder.add(FontModel(it))
        }
        list.add(FontHolderModel(fontHolder))
        val adapter = SuvichaarEditChoiceAdapter(list)
        adapter.setEditChoiceItemClickListener(object :
            SuvichaarEditChoiceAdapter.EditChoiceItemClickListener {
            override fun onClickBackground(backgroundModel: BackgroundModel?) {
                binding?.background?.updateBackground(backgroundModel?.backgroundId)
            }

            override fun onClickFont(fontModel: FontModel?) {
                when(fontModel?.font){
                    Font.FONT_BABY ->{
                        binding?.background?.changeFont(R.style.TextAppearance_Ooohbabyregular)
                    }
                    Font.FONT_FUZZY ->{
                        binding?.background?.changeFont(R.style.TextAppearance_Fuzzybubblesregular)
                    }
                    Font.FONT_INDIE ->{
                        binding?.background?.changeFont(R.style.TextAppearance_Indieflowerregular)
                    }
                    Font.FONT_MOOL ->{
                        binding?.background?.changeFont(R.style.TextAppearance_Moolahlahregular)
                    }
                    Font.FONT_SHIZU ->{
                        binding?.background?.changeFont(R.style.TextAppearance_Shizurueegular)
                    }
                    Font.FONT_PACIF->{
                        binding?.background?.changeFont(R.style.TextAppearance_Pacificoregular)
                    }
                    Font.FONT_TWINK ->{
                        binding?.background?.changeFont(R.style.TextAppearance_twinklestarregular)
                    }
                }
            }

        })
        binding?.rvChoices?.adapter = adapter
    }

    private fun initBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding?.bottomSheet!!)
        bottomSheetBehavior.isHideable = true
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {}

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                binding?.constraintLayout?.progress = slideOffset + 1
            }
        })

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
        binding?.edit?.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
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
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        showIntentChooser(intent)
    }
}