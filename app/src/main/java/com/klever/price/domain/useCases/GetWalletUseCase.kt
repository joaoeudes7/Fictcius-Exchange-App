package com.klever.price.domain.useCases

import com.klever.price.domain.entities.WalletCoinModel
import com.klever.price.domain.repository.WalletRepository
import kotlinx.coroutines.flow.Flow

class GetWalletUseCase(
    private val walletRepository: WalletRepository
) {
    operator fun invoke(): Flow<List<WalletCoinModel>> {
        return walletRepository.getWallet()
    }
}