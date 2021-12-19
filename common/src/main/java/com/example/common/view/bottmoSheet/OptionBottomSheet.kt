package com.example.common.view.bottmoSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.R
import com.example.common.databinding.ViewOptionBottomSheetBinding
import com.example.common.util.getActionBarHeight
import com.example.common.view.recyclerview.OnRecyclerViewOnItemClickListener
import com.google.android.material.bottomsheet.BottomSheetBehavior

/**
 * Created by akash on 31,08,2021
 */
class OptionBottomSheet : BaseBottomSheet() {

    companion object {
        var TAG: String = OptionBottomSheet.javaClass.simpleName

        private const val KEY_OPTIONS = "KEY_OPTIONS"
        private const val KEY_TITLE = "KEY_TITLE"
        fun getInstance(title: String, options: ArrayList<Option>): OptionBottomSheet {
            return OptionBottomSheet().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(KEY_OPTIONS, options)
                    putString(KEY_TITLE, title)
                }
            }
        }
    }

    private lateinit var viewOptionBottomSheetBinding: ViewOptionBottomSheetBinding
    private var options: ArrayList<Option>? = null
    private var title: String? = null
    private var optionAdapter: OptionAdapter? = null
    private var bottomSheetOnItemClickListener: BottomSheetOnItemClickListener<Option>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        options = arguments?.getParcelableArrayList(KEY_OPTIONS)
        title = arguments?.getString(KEY_TITLE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewOptionBottomSheetBinding =
            ViewOptionBottomSheetBinding.inflate(inflater, container, false)
        return viewOptionBottomSheetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseView()
    }

    private fun initialiseView() {
        viewOptionBottomSheetBinding.toolbar.setBackgroundColor(
            resources.getColor(
                R.color.white,
                null
            )
        )
        viewOptionBottomSheetBinding.toolbar.navigationIcon =
            ResourcesCompat.getDrawable(resources, R.drawable.ic_close_24, null)
        title?.let { viewOptionBottomSheetBinding.toolbar.title = it }

        setupRecyclerView()
        setupListener()
    }

    private fun setupRecyclerView() {
        viewOptionBottomSheetBinding.rvOptions.layoutManager = LinearLayoutManager(requireContext())
        optionAdapter = OptionAdapter(options?.toMutableList() ?: mutableListOf())
        optionAdapter?.setItemClickListener(onItemClickListener())
        viewOptionBottomSheetBinding.rvOptions.adapter = optionAdapter
    }

    private fun setupListener() {
        viewOptionBottomSheetBinding.toolbar.setNavigationOnClickListener {
            dismiss()
        }
        setupBottomSheetStateListener(optionBottomSheetStateListener())
    }

    fun setupBottomSheetOnItemClickListener(listener: BottomSheetOnItemClickListener<Option>) {
        bottomSheetOnItemClickListener = listener
    }


    private fun optionBottomSheetStateListener() = object : BottomSheetStateListener {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_EXPANDED -> {
                    viewOptionBottomSheetBinding.toolbar.layoutParams.height = getActionBarHeight(requireActivity())
                    viewOptionBottomSheetBinding.toolbar.requestLayout()
                }
                BottomSheetBehavior.STATE_COLLAPSED -> {
                    viewOptionBottomSheetBinding.toolbar.layoutParams.height = 0
                    viewOptionBottomSheetBinding.toolbar.requestLayout()
                }
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {

        }

    }

    private fun onItemClickListener() =
        OnRecyclerViewOnItemClickListener { parent, view, position ->
            optionAdapter?.getItemAt(position)?.let {
                bottomSheetOnItemClickListener?.onItemClick(it)
                dismiss()
            }
        }

}
