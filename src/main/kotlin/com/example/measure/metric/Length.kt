package com.example.measure.metric

class Length(multiplier: MetricMultiplier) : Metric<Length>(multiplier, "m") {
    override fun normalize() = Length(Base)
}

fun MetricMultiplier.meter(): Metric<Length> = Length(this)

fun meter(): Metric<Length> = Length(Base)