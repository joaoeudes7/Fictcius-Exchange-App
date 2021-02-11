package com.klever.price.ui.fragments.wallet

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdeve.mesanews.base.BaseFragment
import com.klever.price.databinding.WalletFragmentBinding
import com.klever.price.ui.adapter.PairAdapter
import com.klever.price.ui.adapter.WalletAdapter
import com.klever.price.ui.sharedViewModels.MarketViewModel
import com.klever.price.ui.sharedViewModels.WalletViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class WalletFragment : BaseFragment<WalletFragmentBinding>(WalletFragmentBinding::inflate) {

    private val vmWallet by sharedViewModel<WalletViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenResumed {
            vmWallet.fetchWallet()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.run {
        super.onViewCreated(view, savedInstanceState)

        walletList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = WalletAdapter()
        }

        vmWallet.wallet.observe(viewLifecycleOwner) {
            (walletList.adapter as WalletAdapter).submitData(it)
        }
    }
}