package com.example.cryptoappk.domain

import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
   private val repository: CoinRepository
) {
   operator fun invoke() = repository.loadData()
}
