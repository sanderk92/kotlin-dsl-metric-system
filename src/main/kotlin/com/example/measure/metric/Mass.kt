package com.example.measure.metric

class Mass(multiplier: MetricMultiplier) : Metric<Mass>(multiplier, "g") {
    override fun normalize() = Mass(Base)
}

val gram: Metric<Mass> = Mass(Base)
val MetricMultiplier.gram: Metric<Mass> get() = Mass(this)


