package com.example.sanskar.view.suvichaar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sanskar.R
import com.example.sanskar.databinding.ActivitySuvichaarListBinding
import com.example.sanskar.view.PostLoginActivity
import com.example.sanskar.view.suvichaar.adapter.SuvichaarItemModel
import com.example.sanskar.view.suvichaar.adapter.SuvichaarListAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SuvichaarListActivity() : PostLoginActivity() {

    private val TAG = SuvichaarListActivity::class.java.simpleName
    private var binding: ActivitySuvichaarListBinding? = null

    var suvichaarListAdapter = SuvichaarListAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
        populateView()
    }

    private fun initialiseView() {
        binding = ActivitySuvichaarListBinding.inflate(LayoutInflater.from(this))
        setContentView(binding?.root)
    }

    private fun populateView() {
        binding?.rvSuvichaarList?.initRecyclerView {
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            it.adapter = suvichaarListAdapter
        }
        suvichaarListAdapter.addItem(SuvichaarItemModel(getString(R.string.test_mr),R.drawable.bg_blood_pressure))
        suvichaarListAdapter.addItem(SuvichaarItemModel(getString(R.string.test),R.drawable.bg_blood_pressure))
        suvichaarListAdapter.addItem(SuvichaarItemModel(getString(R.string.test),R.drawable.bg_blood_pressure))
    }
}