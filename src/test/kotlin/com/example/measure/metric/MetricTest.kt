package com.example.measure.metric

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.math.abs

class MetricTest {
    
    @Test
    fun `Multipliers have the correct prefix`() {
        assertThat(Yotta.prefix).isEqualTo("Y")
        assertThat(Zetta.prefix).isEqualTo("Z")
        assertThat(Exa.prefix).isEqualTo("E")
        assertThat(Peta.prefix).isEqualTo("P")
        assertThat(Tera.prefix).isEqualTo("T")
        assertThat(Giga.prefix).isEqualTo("G")
        assertThat(Mega.prefix).isEqualTo("M")
        assertThat(Kilo.prefix).isEqualTo("k")
        assertThat(Hecto.prefix).isEqualTo("h")
        assertThat(Deca.prefix).isEqualTo("da")
        assertThat(Base.prefix).isEqualTo("")
        assertThat(Deci.prefix).isEqualTo("d")
        assertThat(Centi.prefix).isEqualTo("c")
        assertThat(Milli.prefix).isEqualTo("m")
        assertThat(Micro.prefix).isEqualTo("μ")
        assertThat(Nano.prefix).isEqualTo("n")
        assertThat(Pico.prefix).isEqualTo("p")
        assertThat(Femto.prefix).isEqualTo("f")
    }

    @Test
    fun `Multipliers have the correct factor`() {
        assertThat(Yotta).isEqualTo(10.toThePowerOf(24))
        assertThat(Zetta).isEqualTo(10.toThePowerOf(21))
        assertThat(Exa).isEqualTo(10.toThePowerOf(18))
        assertThat(Peta).isEqualTo(10.toThePowerOf(15))
        assertThat(Tera).isEqualTo(10.toThePowerOf(12))
        assertThat(Giga).isEqualTo(10.toThePowerOf(9))
        assertThat(Mega).isEqualTo(10.toThePowerOf(6))
        assertThat(Kilo).isEqualTo(10.toThePowerOf(3))
        assertThat(Hecto).isEqualTo(10.toThePowerOf(2))
        assertThat(Deca).isEqualTo(10.toThePowerOf(1))
        assertThat(Base).isEqualTo(10.toThePowerOf(0))
        assertThat(Deci).isEqualTo(10.toThePowerOf(-1))
        assertThat(Centi).isEqualTo(10.toThePowerOf(-2))
        assertThat(Milli).isEqualTo(10.toThePowerOf(-3))
        assertThat(Micro).isEqualTo(10.toThePowerOf(-6))
        assertThat(Nano).isEqualTo(10.toThePowerOf(-9))
        assertThat(Pico).isEqualTo(10.toThePowerOf(-12))
        assertThat(Femto).isEqualTo(10.toThePowerOf(-15))
    }

    @Test
    fun `Multipliers have the correct equals and hashcode`() {
        assertThat(Yotta == Yotta).isTrue
        assertThat(Yotta.hashCode() == Yotta.hashCode()).isTrue
        assertThat(Yotta.hashCode() != Kilo.hashCode()).isTrue
    }
}

private fun Int.toThePowerOf(n: Int): BigDecimal = when {
    n < 0 -> BigDecimal.ONE.setScale(abs(n)) / this.toThePowerOf(abs(n))
    else -> BigDecimal(this).pow(n)
}
