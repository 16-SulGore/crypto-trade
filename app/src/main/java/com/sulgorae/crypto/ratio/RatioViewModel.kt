package com.sulgorae.crypto.ratio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sulgorae.crypto.utils.getTargetPrice
import com.sulgorae.domain.datasource.QuotationDataSource
import kotlinx.coroutines.launch
import java.lang.Double.MAX_VALUE
import java.lang.Double.MIN_VALUE
import java.lang.Double.max
import java.lang.Double.min

class RatioViewModel(
    private val quotationDataSource: QuotationDataSource
) : ViewModel() {

    private var _kDataSet = MutableLiveData<List<MddDataSet>>()
    val kDataSet: LiveData<List<MddDataSet>> = _kDataSet

    fun setProfit(market: String = "KRW-BTC") {
        viewModelScope.launch {
            _kDataSet.value = kList.map { k ->
                with (getMaxMinProfit(market, toList, k)) {
                    MddDataSet(mdd = getMdd(first, second), period = toList.first() + toList.last(), k = k)
                }
            }
        }
    }

    private suspend fun getMaxMinProfit(market: String="KRW-BTC", toList: List<String>, k: Double): Pair<Double, Double> {
        var maxProfit = MIN_VALUE
        var minProfit = MAX_VALUE

        toList.forEach { to ->
            with(quotationDataSource.getDayCandleWithPeriod(market, to)) {
                when {
                    highPrice >= getTargetPrice(k) -> {
                        maxProfit = max(prevClosingPrice - getTargetPrice(k), maxProfit)
                        minProfit = min(prevClosingPrice - getTargetPrice(k), minProfit)
                    }
                    else -> {
                        maxProfit = max(0.0, maxProfit)
                        minProfit = min(0.0, minProfit)
                    }
                }
            }
        }

        return minProfit to maxProfit
    }

    private fun getMdd(minProfit: Double, maxProfit: Double) = (minProfit - maxProfit) / maxProfit

    companion object {

        val kList = listOf(0.5, 0.6, 0.7, 0.8, 0.9, 1.0)

        val toList = listOf("2022-08-01 09:00:00", "2022-08-03 09:00:00")

        const val format = "yyyy-MM-dd HH:mm:ss"
    }
}
