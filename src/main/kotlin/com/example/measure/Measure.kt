package com.example.measure

import com.example.metric.*
import com.example.metric.Unit
import java.math.BigDecimal

// TODO Implement method to convert Multiplier, i.e Kilo -> Femto

data class Measure<T>(val value: BigDecimal, val unit: Unit<T>) {
    override fun toString() = "$value ${unit.suffix}"
}

infix fun <T : Unit<T>> Number.of(unit: Unit<T>) = Measure(
    value = asBigDecimal(),
    unit = unit,
)

operator fun <T: Unit<T>> Measure<T>.plus(other: Measure<T>) = Measure(
    value = normalize().value + other.normalize().value,
    unit = unit.normalize(),
)

operator fun <T: Unit<T>> Measure<T>.minus(other: Measure<T>) = Measure(
    value = normalize().value - other.normalize().value,
    unit = unit.normalize(),
)

operator fun <T : Unit<T>> Measure<T>.div(divisor: Number) = Measure(
    value = value / divisor.asBigDecimal(),
    unit = unit,
)
operator fun <T : Unit<T>> Measure<T>.times(multiplier: Number) = Measure(
    value = value * multiplier.asBigDecimal(),
    unit = unit,
)

private fun <T: Unit<T>> Measure<T>.normalize() = Measure(
    value = value * unit.multiplier.factor,
    unit = unit.normalize()
)

private fun Number.asBigDecimal() = this.toDouble().toBigDecimal()

fun Number.gram() = this of Base.gram()
fun Number.liter() = this of Base.liter()
fun Number.meter() = this of Base.meter()
fun Number.watt() = this of Base.watt()

fun Number.seconds() = this of Base.second()
fun Number.minutes() = this of Base.minute()
fun Number.hours() = this of Base.hour()
fun Number.days() = this of Base.day()

fun gram() = 1.gram()
fun liter() = 1.liter()
fun meter() = 1.meter()
fun watt() = 1.watt()

fun second() = 1.seconds()
fun minute() = 1.minutes()
fun hour() = 1.hours()
fun day() = 1.days()
