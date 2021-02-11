package com.klever.price.domain.useCases

import com.klever.price.domain.entities.PairCoinModel
import com.klever.price.domain.repository.MarketRepository
import kotlinx.coroutines.flow.Flow

class GetPairsMarketUseCase(
    private val marketRepository: MarketRepository
) {
    suspend operator fun invoke(): Flow<List<PairCoinModel>> {
        return marketRepository.getPairsMarketStream()
    }
}