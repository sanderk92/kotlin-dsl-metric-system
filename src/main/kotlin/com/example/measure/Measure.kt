package com.example.measure

import com.example.measure.metric.Unit
import java.math.BigDecimal
import java.math.MathContext

class Measure<T> private constructor(val value: BigDecimal, val unit: Unit<T>) {
    override fun toString() = "${value.toDouble()} ${unit.abbreviation}"

    companion object {
        fun <T> create(value: BigDecimal, unit: Unit<T>) = Measure(
            value = value.stripTrailingZeros(),
            unit = unit,
        )
    }
}

fun <T> Measure<T>.normalized() = Measure.create(
    value = value * unit.multiplier.factor,
    unit = unit.normalize()
)

infix fun <T> Number.of(unit: Unit<T>) = Measure.create(
    value = asBigDecimal(),
    unit = unit,
)

infix fun <T> Measure<T>.convertedTo(unit: Unit<T>) = Measure.create(
    value = normalized().value / unit.multiplier.factor,
    unit = unit,
)

operator fun <T> Measure<T>.plus(other: Measure<T>) = Measure.create(
    value = normalized().value + other.normalized().value,
    unit = unit.normalize(),
)

operator fun <T> Measure<T>.minus(other: Measure<T>) = Measure.create(
    value = normalized().value - other.normalized().value,
    unit = unit.normalize(),
)

operator fun <T> Measure<T>.div(divisor: Number) = Measure.create(
    value = value / divisor.asBigDecimal(),
    unit = unit,
)

operator fun <T> Measure<T>.times(multiplier: Number) = Measure.create(
    value = value * multiplier.asBigDecimal(),
    unit = unit,
)

private fun Number.asBigDecimal() = this.toDouble().toBigDecimal()

private operator fun BigDecimal.div(bigDecimal: BigDecimal) = divide(bigDecimal, MathContext.DECIMAL64)