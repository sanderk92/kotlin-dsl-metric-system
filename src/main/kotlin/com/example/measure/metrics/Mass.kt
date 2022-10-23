package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric
import com.example.measure.MetricMultiplier

data class Mass(override val multiplier: MetricMultiplier) : Metric<Mass>(multiplier, "g") {
    override fun normalize() = Mass(Base)
    override fun toString() = "${multiplier.prefix}${suffix}"
}

val gram: Metric<Mass> = Mass(Base)
val MetricMultiplier.gram: Metric<Mass> get() = Mass(this)


