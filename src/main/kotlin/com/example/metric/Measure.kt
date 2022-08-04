package com.example.metric

data class Measure<T>(val value: Int, val metric: Metric<T>) {
    override fun toString() = "$value${metric.short}"
}

data class DynamicMeasure<T, A>(val num: Measure<T>, val den: Measure<A>) {
    override fun toString() = "${num.value}${num.metric.short}/${den.value}${den.metric.short}"
}

infix fun <T, A> Measure<T>.per(other: Measure<A>) = DynamicMeasure(this, other)

fun gram() = Measure(1, Weight(Base))
fun liter() = Measure(1, Volume(Base))
fun meter() = Measure(1, Distance(Base))

fun second() = Measure(1, Time(Seconds))
fun minute() = Measure(1, Time(Minutes))
fun hour() = Measure(1, Time(Hours))
fun day() = Measure(1, Time(Days))

infix fun Int.of(unit: Weight) = Measure(this, unit)
infix fun Int.of(unit: Volume) = Measure(this, unit)
infix fun Int.of(unit: Distance) = Measure(this, unit)
infix fun Int.of(unit: TimeMultiplier) = Measure(this, Time(unit))
