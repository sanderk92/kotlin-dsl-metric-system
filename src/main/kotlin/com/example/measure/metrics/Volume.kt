package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric
import com.example.measure.MetricMultiplier

data class Volume(override val multiplier: MetricMultiplier) : Metric<Volume>() {
    override val suffix: String = "L"
    override fun normalize() = liter
    override fun toString() = "${multiplier.prefix}$suffix"
}

val liter: Metric<Volume> = Volume(Base)
val MetricMultiplier.liter: Metric<Volume> get() = Volume(this)
