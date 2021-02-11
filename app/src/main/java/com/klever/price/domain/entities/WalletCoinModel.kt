package com.klever.price.domain.entities

import klever.challenge.grpc.WalletCoin

class WalletCoinModel(
    val coinCode: String,
    var equity: Long
) {
    companion object {
        fun fromGrpcEntity(wallet: WalletCoin): WalletCoinModel {
            return WalletCoinModel(
                coinCode = wallet.coinCode,
                equity = wallet.equity
            )
        }
    }
}