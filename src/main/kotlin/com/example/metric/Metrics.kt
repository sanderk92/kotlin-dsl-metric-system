package com.example.metric

import java.math.BigDecimal
import kotlin.math.abs

sealed class Metric<T>(val short: String)

data class Time(val multiplier: TimeMultiplier) : Metric<Time>(multiplier.short)

sealed class TimeMultiplier(val seconds: BigDecimal, val short: String)
object Seconds : TimeMultiplier(BigDecimal(1), "s")
object Minutes : TimeMultiplier(BigDecimal(60), "m")
object Hours : TimeMultiplier(BigDecimal(3_600), "h")
object Days : TimeMultiplier(BigDecimal(86_400), "d")

sealed class MetricUnit<T>(val multiplier: MetricMultiplier, short: String) : Metric<T>(multiplier.short + short)
class Weight(multiplier: MetricMultiplier) : MetricUnit<Weight>(multiplier, "g")
class Volume(multiplier: MetricMultiplier) : MetricUnit<Volume>(multiplier, "l")
class Distance(multiplier: MetricMultiplier) : MetricUnit<Distance>(multiplier, "m")

sealed class MetricMultiplier(val factor: BigDecimal, val short: String)
object Femto : MetricMultiplier(factor = tenToThePower(-15), "f")
object Pico : MetricMultiplier(factor = tenToThePower(-12), "p")
object Nano : MetricMultiplier(factor = tenToThePower(-9), "n")
object Micro : MetricMultiplier(factor = tenToThePower(-6), "μ")
object Milli : MetricMultiplier(factor = tenToThePower(-3), "m")
object Base : MetricMultiplier(factor = BigDecimal.ONE, "")
object Kilo : MetricMultiplier(factor = tenToThePower(3), "K")
object Mega : MetricMultiplier(factor = tenToThePower(6), "M")
object Giga : MetricMultiplier(factor = tenToThePower(9), "G")
object Tera : MetricMultiplier(factor = tenToThePower(12), "T")
object Peta : MetricMultiplier(factor = tenToThePower(15), "P")

fun MetricMultiplier.gram() = Weight(this)
fun MetricMultiplier.liter() = Volume(this)
fun MetricMultiplier.meter() = Distance(this)

private fun tenToThePower(n: Int): BigDecimal = when {
    n < 0 -> BigDecimal.ONE.setScale(abs(n)) / tenToThePower(abs(n))
    n == 0 -> BigDecimal.ZERO
    else -> BigDecimal(10).pow(n)
}

