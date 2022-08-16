package com.sulgorae.crypto.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sulgorae.crypto.menu.MenuViewModel
import com.sulgorae.crypto.ratio.RatioViewModel
import com.sulgorae.domain.datasource.ExchangeDataSource
import com.sulgorae.domain.datasource.QuotationDataSource

class ViewModelFactory(
    private val exchangeDataSource: ExchangeDataSource,
    private val quotationDataSource: QuotationDataSource
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) = with(modelClass) {
        when {
            isAssignableFrom(MenuViewModel::class.java) -> MenuViewModel(exchangeDataSource, quotationDataSource)
            isAssignableFrom(RatioViewModel::class.java) -> RatioViewModel()
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}
