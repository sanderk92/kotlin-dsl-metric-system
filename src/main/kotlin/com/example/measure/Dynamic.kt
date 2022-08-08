package com.example.measure

import com.example.measure.metric.Metric

// TODO Multiplying a Dynamic with a measure

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

infix fun <T, A> Measure<T>.per(other: Measure<A>) = Dynamic.create(
    numerator = this,
    denominator = other,
)

infix fun <T, A> Measure<T>.per(metric: Metric<A>) = Dynamic.create(
    numerator = this,
    denominator = 1.of(metric),
)

operator fun <T, U> Dynamic<T, U>.div(divisor: Number) = Dynamic.create(
    numerator = numerator / divisor,
    denominator = denominator,
)

operator fun <T, U> Dynamic<T, U>.times(multiplier: Number) = Dynamic.create(
    numerator = numerator * multiplier,
    denominator = denominator,
)
