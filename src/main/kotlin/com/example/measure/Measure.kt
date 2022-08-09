package com.example.measure

import com.example.measure.metric.Metric
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

operator fun <T> Measure<T>.plus(measure: Measure<T>) = Measure.create(
    value = normalized().value + measure.normalized().value,
    metric = metric.normalize(),
)

operator fun <T> Measure<T>.minus(measure: Measure<T>) = Measure.create(
    value = normalized().value - measure.normalized().value,
    metric = metric.normalize(),
)

private fun Number.asBigDecimal() = this.toDouble().toBigDecimal()

private operator fun BigDecimal.div(bigDecimal: BigDecimal) = divide(bigDecimal, MathContext.DECIMAL64)