package com.klever.price.domain.entities

import klever.challenge.grpc.PairCoin

class PairCoinModel(
    val code: String,
    val price: Double,
    val percentDiff: Double
) {
    companion object {
        fun fromGrpcEntity(pairCoin: PairCoin): PairCoinModel {
            return PairCoinModel(
                code = pairCoin.code,
                price = pairCoin.price,
                percentDiff = pairCoin.percentDiff
            )
        }
    }
}