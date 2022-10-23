package com.example.measure

import java.math.BigDecimal
import java.math.MathContext.UNLIMITED

operator fun <T> BigDecimal.invoke(metric: Metric<T>) = Measure.create(
    value = this,
    metric = metric,
)

operator fun <T> Number.invoke(metric: Metric<T>) = Measure.create(
    value = this.toDouble().toBigDecimal(),
    metric = metric,
)

data class Measure<T>(val value: BigDecimal, val metric: Metric<T>) {

    companion object {
        fun <T> create(value: BigDecimal, metric: Metric<T>) = Measure(
            value = value.stripTrailingZeros(),
            metric = metric,
        )
    }

    fun normalized() = create(
        value = value * metric.multiplier.factor,
        metric = metric.normalize()
    )

    operator fun plus(other: Measure<T>) = create(
        value = normalized().value + other.normalized().value,
        metric = metric.normalize(),
    )

    operator fun minus(other: Measure<T>) = create(
        value = normalized().value - other.normalized().value,
        metric = metric.normalize(),
    )

    infix fun <T> convertedTo(metric: Metric<T>) = create(
        value = normalized().value.divide(metric.multiplier.factor, UNLIMITED),
        metric = metric,
    )

    override fun toString() = "${value.toPlainString()}$metric"
}

fun <T> List<Measure<T>>.combined() = this.reduce(Measure<T>::plus)
fun <T> List<Measure<T>>.reduced() = this.reduce(Measure<T>::minus)

