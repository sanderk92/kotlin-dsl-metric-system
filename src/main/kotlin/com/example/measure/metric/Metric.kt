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
object Yotta : MetricMultiplier(factor = tenToThePower(24), prefix = "Y")
object Zetta : MetricMultiplier(factor = tenToThePower(21), prefix = "Z")
object Exa : MetricMultiplier(factor = tenToThePower(18), prefix = "E")
object Peta : MetricMultiplier(factor = tenToThePower(15), prefix = "P")
object Tera : MetricMultiplier(factor = tenToThePower(12), prefix = "T")
object Giga : MetricMultiplier(factor = tenToThePower(9), prefix = "G")
object Mega : MetricMultiplier(factor = tenToThePower(6), prefix = "M")
object Kilo : MetricMultiplier(factor = tenToThePower(3), prefix = "k")
object Hecto : MetricMultiplier(factor = tenToThePower(2), prefix = "h")
object Deca : MetricMultiplier(factor = tenToThePower(1), prefix = "da")
object Base : MetricMultiplier(factor = tenToThePower(0), prefix = "")
object Deci : MetricMultiplier(factor = tenToThePower(-1), prefix = "d")
object Centi : MetricMultiplier(factor = tenToThePower(-2), prefix = "c")
object Milli : MetricMultiplier(factor = tenToThePower(-3), prefix = "m")
object Micro : MetricMultiplier(factor = tenToThePower(-6), prefix = "μ")
object Nano : MetricMultiplier(factor = tenToThePower(-9), prefix = "n")
object Pico : MetricMultiplier(factor = tenToThePower(-12), prefix = "p")
object Femto : MetricMultiplier(factor = tenToThePower(-15), prefix = "f")

private fun tenToThePower(n: Int): BigDecimal = when {
    n < 0 -> BigDecimal.ONE.setScale(abs(n)) / tenToThePower(abs(n))
    else -> BigDecimal(10).pow(n)
}
