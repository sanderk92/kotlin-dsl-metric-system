package com.example.measure.metric

class Length(multiplier: MetricMultiplier) : Metric<Length>(multiplier, "m") {
    override fun normalize() = Length(Base)
}

val meter: Metric<Length> = Length(Base)
val MetricMultiplier.meter get() = Length(this)
