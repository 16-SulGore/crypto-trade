package com.sulgorae.crypto.di

import com.sulgorae.domain.datasource.ExchangeDataSource
import com.sulgorae.domain.datasource.QuotationDataSource
import com.sulgorae.remote.datasource.ExchangeRemoteDataSource
import com.sulgorae.remote.datasource.QuotationRemoteDataSource
import com.sulgorae.remote.service.AccountsService
import com.sulgorae.remote.service.TickerService
import retrofit.ApiService

object Injection {

    private val accountsService: AccountsService by lazy { ApiService.upbitClient.create(AccountsService::class.java) }
    val exchangeDataSource: ExchangeDataSource by lazy { ExchangeRemoteDataSource(accountsService) }

    private val tickerService: TickerService by lazy { ApiService.upbitClient.create(TickerService::class.java) }
    val quotationDataSource: QuotationDataSource by lazy { QuotationRemoteDataSource(tickerService)}

}