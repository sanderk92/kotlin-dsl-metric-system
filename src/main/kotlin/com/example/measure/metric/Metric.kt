package com.example.measure.metric

import java.math.BigDecimal
import kotlin.math.abs

sealed class Metric<T>(val multiplier: MetricMultiplier, val suffix: String) {

    /**
     * Normalize a [Metric] to its most basic representation.
     */
    abstract fun normalize(): Metric<T>
}

sealed class MetricMultiplier(val factor: BigDecimal, val prefix: String)
object Femto : MetricMultiplier(factor = tenToThePower(-15), prefix = "f")
object Pico : MetricMultiplier(factor = tenToThePower(-12), prefix = "p")
object Nano : MetricMultiplier(factor = tenToThePower(-9), prefix = "n")
object Micro : MetricMultiplier(factor = tenToThePower(-6), prefix = "μ")
object Milli : MetricMultiplier(factor = tenToThePower(-3), prefix = "m")
object Base : MetricMultiplier(factor = tenToThePower(0), prefix = "")
object Kilo : MetricMultiplier(factor = tenToThePower(3), prefix = "K")
object Mega : MetricMultiplier(factor = tenToThePower(6), prefix = "M")
object Giga : MetricMultiplier(factor = tenToThePower(9), prefix = "G")
object Tera : MetricMultiplier(factor = tenToThePower(12), prefix = "T")
object Peta : MetricMultiplier(factor = tenToThePower(15), prefix = "P")

private fun tenToThePower(n: Int): BigDecimal = when {
    n < 0 -> BigDecimal.ONE.setScale(abs(n)) / tenToThePower(abs(n))
    else -> BigDecimal(10).pow(n)
}
