package com.klever.price.ui.fragments.listPairs

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdeve.mesanews.base.BaseFragment
import com.klever.price.databinding.ListPairsFragmentBinding
import com.klever.price.domain.entities.PairCoinModel
import com.klever.price.ui.adapter.PairAdapter
import com.klever.price.ui.sharedViewModels.MarketViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@Keep
class ListPairsFragment : BaseFragment<ListPairsFragmentBinding>(ListPairsFragmentBinding::inflate) {

    private val vmMarket by sharedViewModel<MarketViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenResumed {
            vmMarket.fetchPairsMarkets()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = binding.run {
        super.onViewCreated(view, savedInstanceState)

        listPairs.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PairAdapter(::onSelectPair)
        }

        vmMarket.pairs.observe(viewLifecycleOwner) {
            (listPairs.adapter as PairAdapter).submitData(it)
        }
    }

    private fun onSelectPair(pairCoinModel: PairCoinModel) {

    }
}