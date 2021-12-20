package com.example.sanskar.view.suvichaar

import android.os.Bundle
import android.view.View
import com.example.common.view.bottmoSheet.Option
import com.example.sanskar.R
import com.example.sanskar.databinding.ActivitySuvichaarBinding
import com.example.sanskar.view.PostLoginActivity

class SuvichaarActivity() : PostLoginActivity() {


    private var binding: ActivitySuvichaarBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()

    }

    private fun initialiseView() {
        binding = ActivitySuvichaarBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

}