package com.klever.price.data.repository

import com.jdeve.mesanews.base.BaseRepository
import com.klever.price.data.sources.remote.ExchangeClient
import com.klever.price.domain.entities.CoinModel
import com.klever.price.domain.entities.OrderModel
import com.klever.price.domain.entities.PairCoinModel
import com.klever.price.domain.repository.MarketRepository
import io.grpc.okhttp.OkHttpChannelBuilder
import klever.challenge.grpc.GetCoinRequest
import klever.challenge.grpc.GetOrderRequest
import klever.challenge.grpc.GetPairsMarketRequest
import klever.challenge.grpc.MarketServiceGrpcKt
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.flow.*
import timber.log.Timber

class MarketRepositoryImpl : BaseRepository(), MarketRepository {

    private val marketService = MarketServiceGrpcKt.MarketServiceCoroutineStub(ExchangeClient.create())

    override suspend fun getPairsMarketStream(): Flow<List<PairCoinModel>> = flow {
        marketService.getPairsMarketStream(GetPairsMarketRequest.newBuilder().build())
            .catch { it.printStackTrace() }
            .collect { response ->
                val pairs = response.pairsList.map {
                    PairCoinModel.fromGrpcEntity(it)
                }

                Timber.e(pairs.toString())

                emit(pairs)
            }
    }

    override suspend fun getCoins() = flow {
        marketService.getCoinsStream(GetCoinRequest.newBuilder().build())
            .catch { it.printStackTrace() }
            .collect { response ->
                val coins = response.coinsList.map {
                    CoinModel.fromCoinGrpc(it)
                }

                Timber.e(coins.toString())

                emit(coins)
            }
    }

    override suspend fun getOrders() = flow {
        marketService.getOrders(GetOrderRequest.newBuilder().build())
            .catch { it.printStackTrace() }
            .collect { response ->
                val orders = response.ordersList.map {
                    OrderModel.fromOrderGrpc(it)
                }

                Timber.e(orders.toString())

                emit(orders)
            }
    }
}