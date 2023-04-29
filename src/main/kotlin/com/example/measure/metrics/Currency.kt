package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric

object Euro : Metric<Euro>() {
    override val suffix: String = "€"
    override val multiplier = Base
    override fun normalize() = euro
    override fun toString() = suffix
}

object Dollar : Metric<Dollar>() {
    override val suffix: String = "$"
    override val multiplier = Base
    override fun normalize() = dollar
    override fun toString() = suffix
}

val euro: Metric<Euro> = Euro
val dollar: Metric<Dollar> = Dollar
