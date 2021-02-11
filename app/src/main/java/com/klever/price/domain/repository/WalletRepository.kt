package com.klever.price.domain.repository

import com.klever.price.domain.entities.WalletCoinModel
import kotlinx.coroutines.flow.Flow

interface WalletRepository {
    fun getWallet(): Flow<List<WalletCoinModel>>
}