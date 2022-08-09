package com.example.measure.metric

import java.math.BigDecimal
import kotlin.math.abs

sealed class Metric<T>(val multiplier: MetricMultiplier, val suffix: String) {

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other === this) return true
        if (other !is Metric<*>) return false
        return other.multiplier == multiplier && other.suffix == suffix
    }

    override fun hashCode(): Int {
        return multiplier.hashCode() + suffix.hashCode()
    }

    override fun toString(): String {
        return "${multiplier.prefix}${suffix}"
    }

    /**
     * Normalize a [Metric] to its most basic representation.
     */
    abstract fun normalize(): Metric<T>
}

sealed class MetricMultiplier(val factor: BigDecimal, val prefix: String)
object Yotta : MetricMultiplier(factor = 10.toThePowerOf(24), prefix = "Y")
object Zetta : MetricMultiplier(factor = 10.toThePowerOf(21), prefix = "Z")
object Exa : MetricMultiplier(factor = 10.toThePowerOf(18), prefix = "E")
object Peta : MetricMultiplier(factor = 10.toThePowerOf(15), prefix = "P")
object Tera : MetricMultiplier(factor = 10.toThePowerOf(12), prefix = "T")
object Giga : MetricMultiplier(factor = 10.toThePowerOf(9), prefix = "G")
object Mega : MetricMultiplier(factor = 10.toThePowerOf(6), prefix = "M")
object Kilo : MetricMultiplier(factor = 10.toThePowerOf(3), prefix = "k")
object Hecto : MetricMultiplier(factor = 10.toThePowerOf(2), prefix = "h")
object Deca : MetricMultiplier(factor = 10.toThePowerOf(1), prefix = "da")
object Base : MetricMultiplier(factor = 10.toThePowerOf(0), prefix = "")
object Deci : MetricMultiplier(factor = 10.toThePowerOf(-1), prefix = "d")
object Centi : MetricMultiplier(factor = 10.toThePowerOf(-2), prefix = "c")
object Milli : MetricMultiplier(factor = 10.toThePowerOf(-3), prefix = "m")
object Micro : MetricMultiplier(factor = 10.toThePowerOf(-6), prefix = "μ")
object Nano : MetricMultiplier(factor = 10.toThePowerOf(-9), prefix = "n")
object Pico : MetricMultiplier(factor = 10.toThePowerOf(-12), prefix = "p")
object Femto : MetricMultiplier(factor = 10.toThePowerOf(-15), prefix = "f")

private fun Int.toThePowerOf(n: Int): BigDecimal = when {
    n < 0 -> BigDecimal.ONE.setScale(abs(n)) / this.toThePowerOf(abs(n))
    else -> BigDecimal(this).pow(n)
}
