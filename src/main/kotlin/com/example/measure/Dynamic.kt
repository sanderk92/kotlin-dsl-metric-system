package com.example.measure

import java.math.BigDecimal
import java.math.MathContext

operator fun <T, U> Measure<T>.div(metric: Metric<U>) = Dynamic(
    numerator = this,
    denominator = 1(metric),
)

operator fun <T, U> Measure<T>.div(measure: Measure<U>) = Dynamic(
    numerator = this,
    denominator = measure,
)

data class Dynamic<T, U>(val numerator: Measure<T>, val denominator: Measure<U>) {

    operator fun times(measure: Measure<U>) = Measure.create(
        value = numerator.normalized().value * (measure.normalized().value / denominator.normalized().value),
        metric = numerator.normalized().metric,
    )

    override fun toString() = "$numerator / $denominator"
}

private operator fun BigDecimal.div(bigDecimal: BigDecimal) = divide(bigDecimal, MathContext.UNLIMITED)