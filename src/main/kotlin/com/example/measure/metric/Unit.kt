package com.example.measure.metric

import java.math.BigDecimal
import kotlin.math.abs

sealed class Unit<T>(val multiplier: UnitMultiplier, val suffix: String) {

    /**
     * Normalize a [Unit] to its most basic representation.
     */
    abstract fun normalize(): Unit<T>
}

sealed class UnitMultiplier(val factor: BigDecimal, val prefix: String)
object Femto : UnitMultiplier(factor = tenToThePower(-15), prefix = "f")
object Pico : UnitMultiplier(factor = tenToThePower(-12), prefix = "p")
object Nano : UnitMultiplier(factor = tenToThePower(-9), prefix = "n")
object Micro : UnitMultiplier(factor = tenToThePower(-6), prefix = "μ")
object Milli : UnitMultiplier(factor = tenToThePower(-3), prefix = "m")
object Base : UnitMultiplier(factor = tenToThePower(0), prefix = "")
object Kilo : UnitMultiplier(factor = tenToThePower(3), prefix = "K")
object Mega : UnitMultiplier(factor = tenToThePower(6), prefix = "M")
object Giga : UnitMultiplier(factor = tenToThePower(9), prefix = "G")
object Tera : UnitMultiplier(factor = tenToThePower(12), prefix = "T")
object Peta : UnitMultiplier(factor = tenToThePower(15), prefix = "P")

private fun tenToThePower(n: Int): BigDecimal = when {
    n < 0 -> BigDecimal.ONE.setScale(abs(n)) / tenToThePower(abs(n))
    else -> BigDecimal(10).pow(n)
}
