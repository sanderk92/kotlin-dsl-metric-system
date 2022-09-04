package com.example.measure

import java.math.BigDecimal
import java.math.MathContext

class Measure<T> private constructor(val value: BigDecimal, val metric: Metric<T>) {

    companion object {
        fun <T> create(value: BigDecimal, metric: Metric<T>) = Measure(
            value = value.stripTrailingZeros(),
            metric = metric,
        )
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other === this) return true
        if (other !is Measure<*>) return false
        return other.value == value && other.metric == metric
    }

    override fun hashCode(): Int {
        return value.hashCode() + metric.hashCode()
    }

    override fun toString(): String {
        return "${value.toPlainString()} $metric"
    }
}

operator fun <T> BigDecimal.invoke(metric: Metric<T>) = Measure.create(
    value = this,
    metric = metric,
)

operator fun <T> Number.invoke(metric: Metric<T>) = Measure.create(
    value = this.toDouble().toBigDecimal(),
    metric = metric,
)

operator fun <T> Measure<T>.plus(measure: Measure<T>) = Measure.create(
    value = normalized.value + measure.normalized.value,
    metric = metric.normalize(),
)

operator fun <T> Measure<T>.minus(measure: Measure<T>) = Measure.create(
    value = normalized.value - measure.normalized.value,
    metric = metric.normalize(),
)

fun <T> List<Measure<T>>.combined() = this.reduce(Measure<T>::plus)
fun <T> List<Measure<T>>.reduced() = this.reduce(Measure<T>::minus)

/**
 * Convert this [Measure] to the specified representation
 */
infix fun <T> Measure<T>.convertedTo(metric: Metric<T>) = Measure.create(
    value = normalized.value / metric.multiplier.factor,
    metric = metric,
)

/**
 * Convert this [Measure] to its most basic representation
 */
val <T> Measure<T>.normalized get() = Measure.create(
    value = value * metric.multiplier.factor,
    metric = metric.normalize()
)

private operator fun BigDecimal.div(bigDecimal: BigDecimal) = divide(bigDecimal, MathContext.UNLIMITED)