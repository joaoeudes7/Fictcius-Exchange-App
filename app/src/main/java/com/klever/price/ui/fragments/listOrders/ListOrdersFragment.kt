package com.klever.price.ui.fragments.listOrders

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdeve.mesanews.base.BaseFragment
import com.klever.price.databinding.ListOrdersFragmentBinding
import com.klever.price.ui.adapter.OrderAdapter
import com.klever.price.ui.sharedViewModels.MarketViewModel
import klever.challenge.grpc.Order
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@Keep
class ListOrdersFragment : BaseFragment<ListOrdersFragmentBinding>(ListOrdersFragmentBinding::inflate) {

    private val vmMarket by sharedViewModel<MarketViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenResumed {
            vmMarket.fetchOrders()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = binding.run {
        super.onViewCreated(view, savedInstanceState)

        listOrders.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = OrderAdapter()
        }

        vmMarket.orders.observe(viewLifecycleOwner) {
            (listOrders.adapter as OrderAdapter).submitData(it)
        }
    }
}