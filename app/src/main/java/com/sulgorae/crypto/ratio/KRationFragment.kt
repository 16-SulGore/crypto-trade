package com.sulgorae.crypto.ratio

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
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
    }

    private fun setChart() {
        ratioViewModel.kDataSet.observe(requireActivity()) { dataSet ->
            binding.lineChartKRatio.data = dataSet.toLineData(R.drawable.done) // FIXME: 차트에 찍을 점 드로어블 지정
        }
    }
}
