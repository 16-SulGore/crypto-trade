package com.sulgorae.crypto.di

import com.sulgorae.domain.datasource.ExchangeDataSource
import com.sulgorae.domain.datasource.QuotationDataSource
import com.sulgorae.remote.datasource.ExchangeRemoteDataSource
import com.sulgorae.remote.datasource.QuotationRemoteDataSource
import com.sulgorae.remote.service.AccountsService
import com.sulgorae.remote.service.QuotationService
import retrofit.ApiService

object Injection {

    private val accountsService: AccountsService by lazy { ApiService.upbitClient.create(AccountsService::class.java) }
    val exchangeDataSource: ExchangeDataSource by lazy { ExchangeRemoteDataSource(accountsService) }

    private val tickerService: QuotationService by lazy { ApiService.upbitClient.create(QuotationService::class.java) }
    val quotationDataSource: QuotationDataSource by lazy { QuotationRemoteDataSource(tickerService)}

}