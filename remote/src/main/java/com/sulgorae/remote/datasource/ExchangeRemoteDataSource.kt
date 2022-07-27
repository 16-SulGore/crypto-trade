package com.sulgorae.remote.datasource

import com.sulgorae.domain.datasource.ExchangeDataSource
import com.sulgorae.remote.service.AccountsService

class ExchangeRemoteDataSource(private val accountsService: AccountsService) : ExchangeDataSource {

    override suspend fun getAccounts() = runCatching {
        accountsService.getAccounts()
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrThrow()
}
