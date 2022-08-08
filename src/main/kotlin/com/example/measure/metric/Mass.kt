package com.example.measure.metric

class Mass(multiplier: MetricMultiplier) : Metric<Mass>(multiplier, "g") {
    override fun normalize() = Mass(Base)
}

fun MetricMultiplier.gram(): Metric<Mass> = Mass(this)

fun gram(): Metric<Mass> = Mass(Base)
