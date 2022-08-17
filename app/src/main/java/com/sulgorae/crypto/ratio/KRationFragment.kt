package com.sulgorae.crypto.ratio

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.components.XAxis
import com.sulgorae.crypto.R
import com.sulgorae.crypto.common.BaseFragment
import com.sulgorae.crypto.databinding.FragmentKRatioBinding
import com.sulgorae.crypto.di.Injection
import com.sulgorae.crypto.di.ViewModelFactory
import com.sulgorae.crypto.utils.toLineData

class KRationFragment : BaseFragment<FragmentKRatioBinding>(R.layout.fragment_k_ratio) {

    private val ratioViewModel: RatioViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(Injection.exchangeDataSource, Injection.quotationDataSource))[RatioViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setChart()

        showChart()
    }

    private fun setChart() {
        ratioViewModel.setProfit()
    }

    private fun showChart() {
        ratioViewModel.kDataSet.observe(requireActivity()) { dataSet ->
            with (binding.lineChartKRatio) {
                val inputData = dataSet.toLineData(R.drawable.crypto1)
                data = inputData
                data.notifyDataChanged()
                notifyDataSetChanged()
                invalidate()
            }
        }
    }
}
