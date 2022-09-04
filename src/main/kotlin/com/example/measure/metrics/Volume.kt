package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric
import com.example.measure.MetricMultiplier

class Volume(multiplier: MetricMultiplier) : Metric<Volume>(multiplier, "l") {
    override fun normalize() = Volume(Base)
}

val liter: Metric<Volume> = Volume(Base)
val MetricMultiplier.liter: Metric<Volume> get() = Volume(this)
