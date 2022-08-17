package com.sulgorae.crypto.ratio

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.sulgorae.crypto.R
import com.sulgorae.crypto.common.BaseFragment
import com.sulgorae.crypto.databinding.FragmentPRatioBinding
import com.sulgorae.crypto.di.Injection
import com.sulgorae.crypto.di.ViewModelFactory
import com.sulgorae.crypto.utils.toLineData

class PRatioFragment : BaseFragment<FragmentPRatioBinding>(R.layout.fragment_p_ratio) {

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
            with(binding.lineChartPRatio) {
                val inputData = dataSet.toLineData(R.drawable.crypto1)
                data = inputData
                data.notifyDataChanged()
                notifyDataSetChanged()
                invalidate()
            }
        }
    }
}
