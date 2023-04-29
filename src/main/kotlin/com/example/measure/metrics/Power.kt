package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric
import com.example.measure.MetricMultiplier

data class Power(override val multiplier: MetricMultiplier) : Metric<Power>() {
    override val suffix: String = "W"
    override fun normalize() = watt
    override fun toString() = "${multiplier.prefix}$suffix"
}

val watt: Metric<Power> = Power(Base)
val MetricMultiplier.watt: Metric<Power> get() = Power(this)
