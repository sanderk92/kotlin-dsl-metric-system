package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric
import com.example.measure.MetricMultiplier

class Power(multiplier: MetricMultiplier) : Metric<Power>(multiplier, "W") {
    override fun normalize() = Power(Base)
}

val watt: Metric<Power> = Power(Base)
val MetricMultiplier.watt: Metric<Power> get() = Power(this)
