package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric
import com.example.measure.MetricMultiplier

data class Length(override val multiplier: MetricMultiplier) : Metric<Length>() {
    override val suffix: String = "m"
    override fun normalize() = meter
    override fun toString() = "${multiplier.prefix}$suffix"
}

val meter: Metric<Length> = Length(Base)
val MetricMultiplier.meter get() = Length(this)
