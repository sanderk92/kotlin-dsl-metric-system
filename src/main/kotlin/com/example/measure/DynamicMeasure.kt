package com.example.measure

import com.example.measure.metric.Metric

class DynamicMeasure<T, U> private constructor(val numerator: Measure<T>, val denominator: Measure<U>) {
    override fun toString() = "$numerator / $denominator"

    companion object {
        fun <T, U> create(numerator: Measure<T>, denominator: Measure<U>) = DynamicMeasure(
            numerator = numerator,
            denominator = denominator,
        )
    }
}

infix fun <T, A> Measure<T>.per(other: Measure<A>) = DynamicMeasure.create(
    numerator = this,
    denominator = other,
)

infix fun <T, A> Measure<T>.per(metric: Metric<A>) = DynamicMeasure.create(
    numerator = this,
    denominator = 1.of(metric),
)

operator fun <T, U> DynamicMeasure<T, U>.div(divisor: Number) = DynamicMeasure.create(
    numerator = numerator / divisor,
    denominator = denominator,
)

operator fun <T, U> DynamicMeasure<T, U>.times(multiplier: Number) = DynamicMeasure.create(
    numerator = numerator * multiplier,
    denominator = denominator,
)
