package com.example.measure.metric

class Volume(multiplier: MetricMultiplier) : Metric<Volume>(multiplier, "l") {
    override fun normalize() = Volume(Base)
}

val liter: Metric<Volume> = Volume(Base)
val MetricMultiplier.liter: Metric<Volume> get() = Volume(this)
