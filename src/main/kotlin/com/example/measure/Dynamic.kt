package com.example.measure

import com.example.measure.metrics.*
import com.example.measure.metrics.Byte
import java.math.BigDecimal
import java.math.BigDecimal.ONE
import java.math.BigDecimal.ZERO
import java.math.MathContext
import javax.management.Query.div

data class Dynamic<T, U>(val numerator: Measure<T>, val denominator: Measure<U>): Comparable<Dynamic<T, U>> {

    fun isEmpty() = numerator.isEmpty()

    fun normalized() = Dynamic(
        numerator = numerator.normalized() / denominator.metric.multiplier.factor,
        denominator = denominator.normalized().copy(value = ONE)
    )

    operator fun plus(other: Dynamic<T, U>) = Dynamic(
        numerator = normalized().numerator + other.normalized().numerator,
        denominator = denominator.normalized(),
    )

    operator fun minus(other: Dynamic<T, U>) = Dynamic(
        numerator = normalized().numerator - other.normalized().numerator,
        denominator = denominator.normalized(),
    )

    operator fun times(measure: Measure<U>) = Measure(
        value = numerator.normalized().value * (measure / denominator.normalized().value).value,
        metric = numerator.normalized().metric,
    )

    override fun compareTo(other: Dynamic<T, U>): Int =
        (this.normalized() - other.normalized()).numerator.value.signum()

    override fun toString(): String =
        "$numerator / $denominator"

    override fun hashCode(): Int =
        numerator.hashCode() + denominator.hashCode()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        val left = this.normalized()
        val right = (other as Dynamic<*, *>).normalized()
        return left.numerator == right.numerator && left.denominator == right.denominator
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