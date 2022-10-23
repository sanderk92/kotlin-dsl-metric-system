package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric
import com.example.measure.MetricMultiplier

data class Volume(override val multiplier: MetricMultiplier) : Metric<Volume>(multiplier, "L") {
    override fun normalize() = Volume(Base)
    override fun toString() = "${multiplier.prefix}${suffix}"
}

val liter: Metric<Volume> = Volume(Base)
val MetricMultiplier.liter: Metric<Volume> get() = Volume(this)
