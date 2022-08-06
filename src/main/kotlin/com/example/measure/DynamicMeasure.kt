package com.example.measure

import com.example.metric.Kilo
import com.example.metric.meter

data class DynamicMeasure<T, U>(val numerator: Measure<T>, val denominator: Measure<U>) {
    override fun toString() = "$numerator / $denominator"
}

infix fun <T, A> Measure<T>.per(other: Measure<A>) = DynamicMeasure(
    numerator = this,
    denominator = other,
)

operator fun <T, U> DynamicMeasure<T, U>.div(divisor: Number) = DynamicMeasure(
    numerator = numerator / divisor,
    denominator = denominator,
)

operator fun <T, U> DynamicMeasure<T, U>.times(multiplier: Number) = DynamicMeasure(
    numerator = numerator * multiplier,
    denominator = denominator,
)
