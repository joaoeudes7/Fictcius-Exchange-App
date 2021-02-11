package com.klever.price.domain.entities

import klever.challenge.grpc.Order

data class OrderModel(
    val id: String? = null,
    val type: TypeOrder,
    val pair: String,
    val amount: Long,
    val price: Double,
    var status: StatusOrder
) {
    companion object {
        fun fromOrderGrpc(order: Order): OrderModel {
            return OrderModel(
                id = order.id,
                type = TypeOrder.valueOf(order.type.name),
                pair = order.pair,
                amount = order.amount,
                price = order.price,
                status = StatusOrder.valueOf(order.status.name)
            )
        }
    }

    enum class TypeOrder {
        buy,
        sell
    }

    enum class StatusOrder {
        pending,
        resolved
    }

    val coins: List<String>
        get() = pair.split("/")

    val coinPurchased: String
        get() = if (type == TypeOrder.buy) {
            coins.first()
        } else {
            coins.last()
        }

    val coinSold: String
        get() = if (type == TypeOrder.sell) {
            coins.first()
        } else {
            coins.last()
        }
}