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

sealed class MetricMultiplier(open val factor: BigDecimal, open val prefix: String)

sealed class Test(override val factor: BigDecimal, override val prefix: String): MetricMultiplier(factor, prefix)
sealed class Test2(override val factor: BigDecimal, override val prefix: String): MetricMultiplier(factor, prefix)
sealed class Test3(override val factor: BigDecimal, override val prefix: String): MetricMultiplier(factor, prefix)

object Yotta : Test(factor = 10.toThePowerOf(24), prefix = "Y")
object Zetta : Test(factor = 10.toThePowerOf(21), prefix = "Z")
object Exa : Test(factor = 10.toThePowerOf(18), prefix = "E")
object Peta : Test(factor = 10.toThePowerOf(15), prefix = "P")
object Tera : Test(factor = 10.toThePowerOf(12), prefix = "T")
object Giga : Test(factor = 10.toThePowerOf(9), prefix = "G")
object Mega : Test(factor = 10.toThePowerOf(6), prefix = "M")
object Kilo : Test(factor = 10.toThePowerOf(3), prefix = "k")
object Hecto : Test(factor = 10.toThePowerOf(2), prefix = "h")
object Deca : Test(factor = 10.toThePowerOf(1), prefix = "da")
object Base : Test2(factor = 10.toThePowerOf(0), prefix = "")
object Deci : Test3(factor = 10.toThePowerOf(-1), prefix = "d")
object Centi : Test3(factor = 10.toThePowerOf(-2), prefix = "c")
object Milli : Test3(factor = 10.toThePowerOf(-3), prefix = "m")
object Micro : Test3(factor = 10.toThePowerOf(-6), prefix = "μ")
object Nano : Test3(factor = 10.toThePowerOf(-9), prefix = "n")
object Pico : Test3(factor = 10.toThePowerOf(-12), prefix = "p")
object Femto : Test3(factor = 10.toThePowerOf(-15), prefix = "f")

private fun Int.toThePowerOf(n: Int): BigDecimal = when {
    n < 0 -> BigDecimal.ONE.setScale(abs(n)) / this.toThePowerOf(abs(n))
    else -> BigDecimal(this).pow(n)
}
