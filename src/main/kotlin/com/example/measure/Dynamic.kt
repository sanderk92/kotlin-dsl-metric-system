package com.example.measure

import com.example.measure.metrics.*
import com.example.measure.metrics.Byte
import java.math.BigDecimal
import java.math.MathContext

class Dynamic<T, U>(val numerator: Measure<T>, val denominator: Measure<U>): Comparable<Dynamic<T, U>> {

    fun isEmpty() = numerator.isEmpty()

    // TODO Broken
    fun normalized() = Dynamic(
        numerator = numerator.normalized(),
        denominator = denominator.normalized()
    )

    // TODO Broken
    operator fun plus(other: Dynamic<T, U>) = Dynamic(
        numerator = numerator.normalized() + other.numerator.normalized(),
        denominator = denominator.normalized(),
    )

    // TODO Broken
    operator fun minus(other: Dynamic<T, U>) = Dynamic(
        numerator = numerator.normalized() - other.numerator.normalized(),
        denominator = denominator.normalized(),
    )

    operator fun times(measure: Measure<U>) = Measure(
        value = numerator.normalized().value * (measure.normalized().value / denominator.normalized().value),
        metric = numerator.normalized().metric,
    )

    // TODO Broken
    override fun compareTo(other: Dynamic<T, U>): Int =
        (this - other).numerator.value.signum()

    override fun toString(): String =
        "$numerator / $denominator"

    override fun hashCode(): Int =
        numerator.hashCode() + denominator.hashCode()

    // TODO Broken
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        (other as Dynamic<*, *>)
        return this.numerator == other.numerator && this.denominator == other.denominator
    }
}

/*
    Creators
 */
operator fun <T, U> Measure<T>.div(metric: Metric<U>) = Dynamic(
    numerator = this,
    denominator = 1(metric),
)

operator fun <T, U> Measure<T>.div(measure: Measure<U>) = Dynamic(
    numerator = this,
    denominator = measure,
)

/*
    Aliases
 */
typealias Speed = Dynamic<Length, Time>
typealias Energy = Dynamic<Power, Time>
typealias MassFlowRate = Dynamic<Mass, Time>
typealias VolumeFlowRate = Dynamic<Volume, Time>
typealias TransferRate = Dynamic<Byte, Time>
typealias PowerDensity = Dynamic<Power, Volume>
typealias MassConcentration = Dynamic<Mass, Volume>
typealias VolumeConcentration = Dynamic<Volume, Volume>

private operator fun BigDecimal.div(bigDecimal: BigDecimal) = divide(bigDecimal, MathContext.UNLIMITED)