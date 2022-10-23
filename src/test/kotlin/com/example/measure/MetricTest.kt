package com.example.measure

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.math.abs

class MetricTest {

    @Test
    fun `Multipliers have the correct prefix`() {
        Assertions.assertThat(Yotta.prefix).isEqualTo("Y")
        Assertions.assertThat(Zetta.prefix).isEqualTo("Z")
        Assertions.assertThat(Exa.prefix).isEqualTo("E")
        Assertions.assertThat(Peta.prefix).isEqualTo("P")
        Assertions.assertThat(Tera.prefix).isEqualTo("T")
        Assertions.assertThat(Giga.prefix).isEqualTo("G")
        Assertions.assertThat(Mega.prefix).isEqualTo("M")
        Assertions.assertThat(Kilo.prefix).isEqualTo("k")
        Assertions.assertThat(Hecto.prefix).isEqualTo("h")
        Assertions.assertThat(Deca.prefix).isEqualTo("da")
        Assertions.assertThat(Base.prefix).isEqualTo("")
        Assertions.assertThat(Deci.prefix).isEqualTo("d")
        Assertions.assertThat(Centi.prefix).isEqualTo("c")
        Assertions.assertThat(Milli.prefix).isEqualTo("m")
        Assertions.assertThat(Micro.prefix).isEqualTo("μ")
        Assertions.assertThat(Nano.prefix).isEqualTo("n")
        Assertions.assertThat(Pico.prefix).isEqualTo("p")
        Assertions.assertThat(Femto.prefix).isEqualTo("f")
    }

    @Test
    fun `Multipliers have the correct factor`() {
        Assertions.assertThat(Yotta.factor).isEqualTo(10.toThePowerOf(24))
        Assertions.assertThat(Zetta.factor).isEqualTo(10.toThePowerOf(21))
        Assertions.assertThat(Exa.factor).isEqualTo(10.toThePowerOf(18))
        Assertions.assertThat(Peta.factor).isEqualTo(10.toThePowerOf(15))
        Assertions.assertThat(Tera.factor).isEqualTo(10.toThePowerOf(12))
        Assertions.assertThat(Giga.factor).isEqualTo(10.toThePowerOf(9))
        Assertions.assertThat(Mega.factor).isEqualTo(10.toThePowerOf(6))
        Assertions.assertThat(Kilo.factor).isEqualTo(10.toThePowerOf(3))
        Assertions.assertThat(Hecto.factor).isEqualTo(10.toThePowerOf(2))
        Assertions.assertThat(Deca.factor).isEqualTo(10.toThePowerOf(1))
        Assertions.assertThat(Base.factor).isEqualTo(10.toThePowerOf(0))
        Assertions.assertThat(Deci.factor).isEqualTo(10.toThePowerOf(-1))
        Assertions.assertThat(Centi.factor).isEqualTo(10.toThePowerOf(-2))
        Assertions.assertThat(Milli.factor).isEqualTo(10.toThePowerOf(-3))
        Assertions.assertThat(Micro.factor).isEqualTo(10.toThePowerOf(-6))
        Assertions.assertThat(Nano.factor).isEqualTo(10.toThePowerOf(-9))
        Assertions.assertThat(Pico.factor).isEqualTo(10.toThePowerOf(-12))
        Assertions.assertThat(Femto.factor).isEqualTo(10.toThePowerOf(-15))
    }
}

private fun Int.toThePowerOf(n: Int): BigDecimal = when {
    n < 0 -> BigDecimal.ONE.setScale(abs(n)) / this.toThePowerOf(abs(n))
    else -> BigDecimal(this).pow(n)
}
