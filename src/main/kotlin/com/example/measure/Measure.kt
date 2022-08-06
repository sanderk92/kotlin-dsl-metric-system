package com.example.measure

import com.example.metric.*
import com.example.metric.Unit
import java.math.BigDecimal

// TODO Implement method to convert Multiplier, i.e Kilo -> Femto

class Measure<T>(val value: BigDecimal, val unit: Unit<T>) {
    override fun toString() = "$value ${unit.suffix}"
}

fun <T> Measure<T>.normalize() = Measure(
    value = value * unit.multiplier.factor,
    unit = unit.normalize()
)

infix fun <T> Number.of(unit: Unit<T>) = Measure(
    value = asBigDecimal(),
    unit = unit,
)

operator fun <T> Measure<T>.plus(other: Measure<T>) = Measure(
    value = normalize().value + other.normalize().value,
    unit = unit.normalize(),
)

operator fun <T> Measure<T>.minus(other: Measure<T>) = Measure(
    value = normalize().value - other.normalize().value,
    unit = unit.normalize(),
)

operator fun <T> Measure<T>.div(divisor: Number) = Measure(
    value = value / divisor.asBigDecimal(),
    unit = unit,
)
operator fun <T> Measure<T>.times(multiplier: Number) = Measure(
    value = value * multiplier.asBigDecimal(),
    unit = unit,
)

private fun Number.asBigDecimal() = this.toDouble().toBigDecimal()

/*
Factory methods for Measure of Weight
 */
fun milligram() = 1.milligram()
fun gram() = 1.gram()
fun kilogram() = 1.kilogram()

fun Number.milligram() = this of Milli.gram()
fun Number.gram() = this of Base.gram()
fun Number.kilogram() = this of Kilo.gram()

/*
Factory methods for Measure of Volume
 */
fun microliter() = 1.microliter()
fun milliliter() = 1.milliliter()
fun liter() = 1.liter()

fun Number.microliter() = this of Micro.liter()
fun Number.milliliter() = this of Milli.liter()
fun Number.liter() = this of Base.liter()

/*
Factory methods for Measure of Distance
 */
fun millimeter() = 1.millimeter()
fun meter() = 1.meter()
fun kilometer() = 1.kilometer()

fun Number.millimeter() = this of Milli.meter()
fun Number.meter() = this of Base.meter()
fun Number.kilometer() = this of Kilo.meter()

/*
Factory methods for Measure of Power
 */
fun watt() = 1.watt()
fun kilowatt() = 1.kilowatt()
fun megawatt() = 1.megawatt()

fun Number.watt() = this of Base.watt()
fun Number.kilowatt() = this of Kilo.watt()
fun Number.megawatt() = this of Mega.watt()

/*
Factory methods for Measure of Time
 */
fun second() = 1.seconds()
fun minute() = 1.minutes()
fun hour() = 1.hours()
fun day() = 1.days()

fun Number.seconds() = this of Base.second()
fun Number.minutes() = this of Base.minute()
fun Number.hours() = this of Base.hour()
fun Number.days() = this of Base.day()
