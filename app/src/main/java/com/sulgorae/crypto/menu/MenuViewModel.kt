package com.sulgorae.crypto.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sulgorae.domain.datasource.ExchangeDataSource
import com.sulgorae.domain.datasource.QuotationDataSource
import kotlinx.coroutines.launch

class MenuViewModel(
    private val exchangeDataSource: ExchangeDataSource,
    private val quotationDataSource: QuotationDataSource
) : ViewModel() {

    private val _totalAccount = MutableLiveData(0.0)
    val totalAccount: LiveData<Double> = _totalAccount

    init {
        setTotalAccount()
    }

    private fun setTotalAccount() {
        viewModelScope.launch {
            _totalAccount.value = exchangeDataSource.getAccounts().fold(0.0) { acc, account ->
                acc + account.balance * when (account.currency) {
                    "KRW" -> account.balance
                    else -> quotationDataSource.getTicker(account.unitCurrency + "-" + account.currency).tradePrice
                }
            }
        }
    }
}
