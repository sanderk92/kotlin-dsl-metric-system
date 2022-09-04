package com.example.measure

import java.math.BigDecimal
import java.math.MathContext

class Dynamic<T, U> private constructor(val numerator: Measure<T>, val denominator: Measure<U>) {

    companion object {
        fun <T, U> create(numerator: Measure<T>, denominator: Measure<U>) = Dynamic(
            numerator = numerator,
            denominator = denominator,
        )
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other === this) return true
        if (other !is Dynamic<*, *>) return false
        return other.numerator == numerator && other.denominator == denominator
    }

    override fun hashCode(): Int {
        return numerator.hashCode() + denominator.hashCode()
    }

    override fun toString(): String {
        return "$numerator / $denominator"
    }
}

operator fun <T, U> Measure<T>.div(metric: Metric<U>) = Dynamic.create(
    numerator = this,
    denominator = 1(metric),
)

operator fun <T, U> Measure<T>.div(measure: Measure<U>) = Dynamic.create(
    numerator = this,
    denominator = measure,
)

operator fun <T, U> Dynamic<T, U>.times(measure: Measure<U>) = Measure.create(
    value = numerator.normalized.value * (measure.normalized.value / denominator.normalized.value),
    metric = numerator.normalized.metric,
)

private operator fun BigDecimal.div(bigDecimal: BigDecimal) = divide(bigDecimal, MathContext.UNLIMITED)