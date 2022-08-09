package com.example.measure.metric

class Power(multiplier: MetricMultiplier) : Metric<Power>(multiplier, "W") {
    override fun normalize() = Power(Base)
}

val watt: Metric<Power> = Power(Base)
val MetricMultiplier.watt: Metric<Power> get() = Power(this)
