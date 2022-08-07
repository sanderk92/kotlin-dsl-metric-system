package com.example.measure.metric

class Power(multiplier: MetricMultiplier) : Metric<Power>(multiplier, "W") {
    override fun normalize() = Power(Base)
}

fun MetricMultiplier.watt(): Metric<Power> = Power(this)