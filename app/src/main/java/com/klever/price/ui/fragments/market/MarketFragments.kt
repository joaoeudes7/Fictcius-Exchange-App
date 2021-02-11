package com.klever.price.ui.fragments.market

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.lifecycle.lifecycleScope
import com.jdeve.mesanews.base.BaseFragment
import com.klever.price.databinding.MarketFragmentBinding
import com.klever.price.ui.sharedViewModels.MarketViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@Keep
class MarketFragments : BaseFragment<MarketFragmentBinding>(MarketFragmentBinding::inflate) {

    private val vmMarket by sharedViewModel<MarketViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenResumed {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun buy() {

    }

    private fun sell() {

    }
}