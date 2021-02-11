package com.klever.price.domain.entities

import klever.challenge.grpc.Coin

data class CoinModel(
    val code: String,
    var value: Double,
    var available: Long
) {

    companion object {
        fun fromCoinGrpc(coin: Coin): CoinModel {
            return CoinModel(
                code = coin.code,
                value = coin.value,
                available = coin.available
            )
        }
    }
}