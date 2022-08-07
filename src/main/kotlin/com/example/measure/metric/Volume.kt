package com.example.measure.metric

class Volume(multiplier: MetricMultiplier) : Metric<Volume>(multiplier, "l") {
    override fun normalize() = Volume(Base)
}

fun MetricMultiplier.liter(): Metric<Volume> = Volume(this)