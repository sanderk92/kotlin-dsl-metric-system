package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric
import com.example.measure.MetricMultiplier

data class Length(override val multiplier: MetricMultiplier) : Metric<Length>(multiplier, "m") {
    override fun normalize() = Length(Base)
    override fun toString() = "${multiplier.prefix}${suffix}"
}

val meter: Metric<Length> = Length(Base)
val MetricMultiplier.meter get() = Length(this)
