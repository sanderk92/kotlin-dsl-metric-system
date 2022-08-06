package com.example.measure

import com.example.measure.metric.Unit
import com.example.measure.metric.UnitMultiplier
import java.math.BigDecimal

// TODO Divisor scales are incorrect
// TODO Measure constructor removing trailing zeroes

class Measure<T>(val value: BigDecimal, val unit: Unit<T>) {
    override fun toString() = "$value ${unit.suffix}"
}

infix fun <T> Number.of(unit: Unit<T>) = Measure(
    value = asBigDecimal(),
    unit = unit,
)

infix fun <T> Measure<T>.convertedTo(unit: Unit<T>) = Measure(
    value = normalize().value / unit.multiplier.factor,
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

private fun <T> Measure<T>.normalize() = Measure(
    value = value * unit.multiplier.factor,
    unit = unit.normalize()
)

private fun Number.asBigDecimal() = this.toDouble().toBigDecimal()
