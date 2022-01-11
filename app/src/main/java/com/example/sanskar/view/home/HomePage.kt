package com.example.sanskar.view.home

import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.sanskar.databinding.ActivityHomepageBinding
import com.example.sanskar.view.BannerModel
import com.example.sanskar.view.BannerVpAdapter
import com.example.sanskar.view.PostLoginActivity
import com.example.sanskar.view.home.adapter.*
import com.google.android.material.tabs.TabLayoutMediator

class HomePage() : PostLoginActivity() {

    private var binding: ActivityHomepageBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
        populateView()
    }

    private fun populateView() {
        initViewPager()
        initFeatureView()
    }

    private fun initFeatureView() {
        val list = mutableListOf(
            TitleModel("Suvichaar", ViewType.VIEW_TITLE), FeatureModel(
                ViewType.VIEW_FEATURE,
                mutableListOf(
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO")
                )
            ),
            TitleModel("Suvichaar", ViewType.VIEW_TITLE),
            FeatureModel(
                ViewType.VIEW_FEATURE,
                mutableListOf(
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO")
                )
            ),
            TitleModel("Suvichaar", ViewType.VIEW_TITLE),
            FeatureModel(
                ViewType.VIEW_FEATURE,
                mutableListOf(
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO")
                )
            ),
            TitleModel("Suvichaar", ViewType.VIEW_TITLE),
            FeatureModel(
                ViewType.VIEW_FEATURE,
                mutableListOf(
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO"),
                    ChoiceModel("HELLO")
                )
            )
        )
        val adapter1 = FeaturesRvAdapter(list)
        binding?.rvFeatures?.initRecyclerView {
            it.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            it.adapter = adapter1
        }
    }

    private fun initViewPager() {
        binding?.vpBanner?.adapter = BannerVpAdapter(
            mutableListOf(
                BannerModel(),
                BannerModel(), BannerModel()
            )
        )
        binding?.vpBanner?.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(
            binding?.tlBanner!!,
            binding?.vpBanner!!
        ) { tab, position ->

        }.attach()
    }

    private fun initialiseView() {
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }


}