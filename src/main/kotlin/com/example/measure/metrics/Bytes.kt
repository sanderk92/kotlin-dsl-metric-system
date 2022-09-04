package com.example.measure.metrics

import com.example.measure.*
import java.math.BigDecimal.ONE

class Byte(multiplier: MetricMultiplier) : Metric<Byte>(multiplier, "b") {
    init {
        check(multiplier.factor >= ONE) { "Byte does not support multiplier '${multiplier}'" }
    }

    override fun normalize() = Byte(Base)
}

val byte: Metric<Byte> = Byte(Base)

val Yotta.byte: Metric<Byte> get() = Byte(this)
val Zetta.byte: Metric<Byte> get() = Byte(this)
val Exa.byte: Metric<Byte> get() = Byte(this)
val Peta.byte: Metric<Byte> get() = Byte(this)
val Tera.byte: Metric<Byte> get() = Byte(this)
val Giga.byte: Metric<Byte> get() = Byte(this)
val Mega.byte: Metric<Byte> get() = Byte(this)
val Kilo.byte: Metric<Byte> get() = Byte(this)
val Hecto.byte: Metric<Byte> get() = Byte(this)
val Deca.byte: Metric<Byte> get() = Byte(this)
val Base.byte: Metric<Byte> get() = Byte(this)
