package com.sulgorae.crypto.utils

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.sulgorae.crypto.ratio.MddDataSet

fun List<MddDataSet>.toLineData(iconId: Int, k: Double = 0.5) = LineData(
    arrayListOf<ILineDataSet>(
        LineDataSet(
            map { Entry(it.k.toFloat(), it.mdd.toFloat(), iconId) }, k.toString()
        )
    )
)
