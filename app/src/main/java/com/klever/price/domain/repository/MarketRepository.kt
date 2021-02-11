package com.klever.price.domain.repository

import com.klever.price.domain.entities.CoinModel
import com.klever.price.domain.entities.OrderModel
import com.klever.price.domain.entities.PairCoinModel
import kotlinx.coroutines.flow.Flow

interface MarketRepository {

    suspend fun getPairsMarketStream(): Flow<List<PairCoinModel>>
    suspend fun getCoins(): Flow<List<CoinModel>>
    suspend fun getOrders(): Flow<List<OrderModel>>
}