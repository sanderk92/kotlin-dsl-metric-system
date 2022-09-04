package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric
import com.example.measure.MetricMultiplier

class Mass(multiplier: MetricMultiplier) : Metric<Mass>(multiplier, "g") {
    override fun normalize() = Mass(Base)
}

val gram: Metric<Mass> = Mass(Base)
val MetricMultiplier.gram: Metric<Mass> get() = Mass(this)


