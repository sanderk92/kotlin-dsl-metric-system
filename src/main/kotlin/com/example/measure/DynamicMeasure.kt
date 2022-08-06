package com.example.measure

data class DynamicMeasure<T, A>(val num: Measure<T>, val den: Measure<A>) {
    override fun toString() = "$num / $den"
}

infix fun <T, A> Measure<T>.per(other: Measure<A>) = DynamicMeasure(this, other)
