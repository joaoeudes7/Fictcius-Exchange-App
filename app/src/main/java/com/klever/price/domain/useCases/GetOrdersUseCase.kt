package com.klever.price.domain.useCases

import com.klever.price.domain.entities.OrderModel
import com.klever.price.domain.repository.MarketRepository
import kotlinx.coroutines.flow.Flow

class GetOrdersUseCase(
    private val marketRepository: MarketRepository
) {
    suspend operator fun invoke(): Flow<List<OrderModel>> {
        return marketRepository.getOrders()
    }
}