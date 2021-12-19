package com.example.common.view.bottmoSheet

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.common.databinding.ViewUploadChoiceBottomSheetBinding
import com.example.common.model.FileDetail
import com.example.common.util.getFileDetail
import com.example.common.util.getTempFileUri

/**
 * Created by akash on 29,10,2021
 */
class UploadChoiceBottomSheet() : BaseBottomSheet() {

    interface FileSelectionListener {
        fun onFileSelected(file: FileDetail)
    }

    companion object {
        var TAG: String = UploadChoiceBottomSheet.javaClass.simpleName
        fun getInstance(): UploadChoiceBottomSheet {
            return UploadChoiceBottomSheet()
        }
    }

    private var binding: ViewUploadChoiceBottomSheetBinding? = null
    private var tempFileUri: Uri? = null
    private var fileSelectionListener: FileSelectionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewUploadChoiceBottomSheetBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        setupListener()
    }

    private fun setupListener() {
        binding?.camera?.setOnClickListener {
            tempFileUri = getTempFileUri(requireContext())
            launchCamera.launch(tempFileUri)
        }
    }

    fun setFileSelectionListener(listener: FileSelectionListener) {
        fileSelectionListener = listener
    }

    private var launchCamera = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        if (it) {
            dismissBottomSheet()
            tempFileUri?.let { uri ->
                fileSelectionListener?.onFileSelected(getFileDetail(requireContext(), uri))
            }
        }
    }

}