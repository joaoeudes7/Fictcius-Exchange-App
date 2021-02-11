package com.klever.price.ui.fragments.listCoins

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdeve.mesanews.base.BaseFragment
import com.klever.price.databinding.ListCoinsBinding
import com.klever.price.domain.entities.CoinModel
import com.klever.price.ui.adapter.CoinAdapter
import com.klever.price.ui.sharedViewModels.MarketViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@Keep
class ListCoins : BaseFragment<ListCoinsBinding>(ListCoinsBinding::inflate) {

    private val vmMarket by sharedViewModel<MarketViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenResumed {
            vmMarket.fetchCoins()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.run {
        super.onViewCreated(view, savedInstanceState)

        listCoins.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CoinAdapter()
        }

        vmMarket.coins.observe(viewLifecycleOwner) {
            (listCoins.adapter as CoinAdapter).submitData(it)
        }
    }

    private fun onSelectCoin(coin: CoinModel) {
        findNavController()
    }


}