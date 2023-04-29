package com.example.measure

import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.math.MathContext
import java.math.MathContext.*

data class Measure<T>(val value: BigDecimal, val metric: Metric<T>) : Comparable<Measure<T>> {

    fun isEmpty() = value.compareTo(ZERO) == 0

    fun normalized() = Measure(
        value = value * metric.multiplier.factor,
        metric = metric.normalize()
    )

    operator fun plus(other: Measure<T>) = Measure(
        value = normalized().value + other.normalized().value,
        metric = metric.normalize(),
    )

    operator fun minus(other: Measure<T>) = Measure(
        value = normalized().value - other.normalized().value,
        metric = metric.normalize(),
    )

    operator fun times(value: BigDecimal) = Measure(
        value = normalized().value.multiply(value),
        metric = metric
    )

    operator fun div(value: BigDecimal) = Measure(
        value = normalized().value.divide(value, DECIMAL64),
        metric = metric.normalize(),
    )

    infix fun `in`(metric: Metric<T>) = Measure(
        value = (this / metric.multiplier.factor).value,
        metric = metric,
    )

    override fun compareTo(other: Measure<T>): Int =
        (this - other).value.signum()

    override fun toString(): String =
        "${value.stripTrailingZeros().toPlainString()}$metric"

    override fun hashCode(): Int =
        normalized().let { value.hashCode() * metric.hashCode() * 31 }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        val left = this.normalized()
        val right = (other as Measure<*>).normalized()
        return left.metric == right.metric && left.value.compareTo(right.value) == 0
    }
}

/*
    Creators
 */
operator fun <T> BigDecimal.invoke(metric: Metric<T>) = Measure(
    value = this,
    metric = metric,
)

operator fun <T> Int.invoke(metric: Metric<T>) = Measure(
    value = this.toBigDecimal(),
    metric = metric,
)

operator fun <T> Double.invoke(metric: Metric<T>) = Measure(
    value = this.toBigDecimal(),
    metric = metric,
)

/*
    Combinators
 */
fun <T> List<Measure<T>>.combined() = reduce(Measure<T>::plus)
fun <T> List<Measure<T>>.reduced() = reduce(Measure<T>::minus)
