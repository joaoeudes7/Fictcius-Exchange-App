package com.klever.price.data.repository

import com.jdeve.mesanews.base.BaseRepository
import com.klever.price.data.sources.remote.ExchangeClient
import com.klever.price.domain.entities.WalletCoinModel
import com.klever.price.domain.repository.WalletRepository
import io.grpc.okhttp.OkHttpChannelBuilder
import klever.challenge.grpc.GetWalletRequest
import klever.challenge.grpc.WalletServiceGrpcKt
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class WalletRepositoryImpl : BaseRepository(), WalletRepository {

    private val walletService = WalletServiceGrpcKt.WalletServiceCoroutineStub(ExchangeClient.create())

    override fun getWallet() = flow {
        walletService.getWalletStream(GetWalletRequest.newBuilder().build())
            .catch { it.printStackTrace() }
            .collect { response ->
                val wallet = response.coinsList.map {
                    WalletCoinModel.fromGrpcEntity(it)
                }

                emit(wallet)
            }
    }
}