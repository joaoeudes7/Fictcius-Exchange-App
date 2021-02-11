package com.klever.price.ui.sharedViewModels

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.klever.price.base.BaseViewModel
import com.klever.price.data.repository.MarketRepositoryImpl
import com.klever.price.domain.entities.CoinModel
import com.klever.price.domain.entities.OrderModel
import com.klever.price.domain.entities.PairCoinModel
import com.klever.price.domain.useCases.GetCoinsUseCase
import com.klever.price.domain.useCases.GetOrdersUseCase
import com.klever.price.domain.useCases.GetPairsMarketUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MarketViewModel(
    private val getPairsMarketUseCase: GetPairsMarketUseCase,
    private val getCoinsUserCase: GetCoinsUseCase,
    private val getOrdersUseCase: GetOrdersUseCase
) : BaseViewModel() {
    private val _coins = MutableStateFlow(listOf<CoinModel>())
    private val _pairs = MutableStateFlow(listOf<PairCoinModel>())
    private val _orders = MutableStateFlow(listOf<OrderModel>())

    val orders = _orders.asLiveData()
    val coins = _coins.asLiveData()
    val pairs = _pairs.asLiveData()

    fun fetchPairsMarkets() = viewModelScope.launch {
        getPairsMarketUseCase()
            .catch { it.printStackTrace() }
            .collect { pairs ->
                _pairs.value = pairs
            }
    }

    fun fetchCoins() = viewModelScope.launch {
        getCoinsUserCase()
            .catch { it.printStackTrace() }
            .collect { _coins.value = it }
    }

    fun fetchOrders() = viewModelScope.launch {
        getOrdersUseCase()
            .catch { it.printStackTrace() }
            .collect { _orders.value = it }
    }

    fun buy(orderModel: OrderModel) {

    }

    fun sell(orderModel: OrderModel) {

    }
}