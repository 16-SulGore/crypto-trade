package com.sulgorae.crypto.utils

import com.sulgorae.domain.entity.DayCandleEntity

fun DayCandleEntity.getTargetPrice(k: Double) = k * (highPrice - lowPrice)