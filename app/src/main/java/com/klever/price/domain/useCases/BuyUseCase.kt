package com.klever.price.domain.useCases

import com.klever.price.domain.repository.MarketRepository

class BuyUseCase(
    private val marketRepository: MarketRepository
) {
    operator fun invoke() {

    }
}