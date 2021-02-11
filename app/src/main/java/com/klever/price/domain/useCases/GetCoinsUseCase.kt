package com.klever.price.domain.useCases

import com.klever.price.domain.entities.CoinModel
import com.klever.price.domain.repository.MarketRepository
import kotlinx.coroutines.flow.Flow

class GetCoinsUseCase(
    private val marketRepository: MarketRepository
) {
    suspend operator fun invoke(): Flow<List<CoinModel>> {
        return marketRepository.getCoins()
    }
}