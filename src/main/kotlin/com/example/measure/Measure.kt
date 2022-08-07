package com.example.measure

import com.example.measure.metric.Metric
import java.math.BigDecimal
import java.math.MathContext

class Measure<T> private constructor(val value: BigDecimal, val metric: Metric<T>) {
    override fun toString() = "${value.toDouble()} ${metric.multiplier.prefix}${metric.suffix}"

    companion object {
        fun <T> create(value: BigDecimal, metric: Metric<T>) = Measure(
            value = value.stripTrailingZeros(),
            metric = metric,
        )
    }
}

fun <T> Measure<T>.normalized() = Measure.create(
    value = value * metric.multiplier.factor,
    metric = metric.normalize()
)

infix fun <T> Number.of(metric: Metric<T>) = Measure.create(
    value = asBigDecimal(),
    metric = metric,
)

infix fun <T> Measure<T>.convertedTo(metric: Metric<T>) = Measure.create(
    value = normalized().value / metric.multiplier.factor,
    metric = metric,
)

operator fun <T> Measure<T>.plus(other: Measure<T>) = Measure.create(
    value = normalized().value + other.normalized().value,
    metric = metric.normalize(),
)

operator fun <T> Measure<T>.minus(other: Measure<T>) = Measure.create(
    value = normalized().value - other.normalized().value,
    metric = metric.normalize(),
)

operator fun <T> Measure<T>.div(divisor: Number) = Measure.create(
    value = value / divisor.asBigDecimal(),
    metric = metric,
)

operator fun <T> Measure<T>.times(multiplier: Number) = Measure.create(
    value = value * multiplier.asBigDecimal(),
    metric = metric,
)

private fun Number.asBigDecimal() = this.toDouble().toBigDecimal()

private operator fun BigDecimal.div(bigDecimal: BigDecimal) = divide(bigDecimal, MathContext.DECIMAL64)