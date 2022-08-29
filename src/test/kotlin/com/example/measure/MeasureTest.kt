package com.example.measure

import com.example.measure.invoke
import com.example.measure.metric.*
import com.example.measure.normalized
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class MeasureTest {

    @Test
    fun `BigDecimals can be used to instantiate a measure`() {
        val result = BigDecimal.ONE(meter)
        assertThat(result.value).isEqualTo(BigDecimal.ONE)
        assertThat(result.metric).isEqualTo(Base.meter)
    }

    @Test
    fun `Numbers can be used to instantiate a measure`() {
        val result = 1(meter)
        assertThat(result.value).isEqualTo(BigDecimal.ONE)
        assertThat(result.metric).isEqualTo(Base.meter)
    }

    @Test
    fun `Two measures can be added`() {
        val first = 2(meter)
        val second = 1(meter)
        assertThat(first + second).isEqualTo(3(meter))
    }

    @Test
    fun `Two measures can be subtracted`() {
        val first = 2(meter)
        val second = 1(meter)
        assertThat(first - second).isEqualTo(1(meter))
    }

    @Test
    fun `A measure can be normalized`() {
        val values = 30(Kilo.meter)
        assertThat(values.normalized).isEqualTo(30_000(meter))
    }

    @Test
    fun `A measure can be converted to a different multiplier`() {
        val value = 30(Kilo.meter)
        assertThat(value convertedTo meter).isEqualTo(30_000(meter))
    }

    @Test
    fun `A list of measures can be combined`() {
        val values = listOf(30(Kilo.meter), 30(meter))
        assertThat(values.combined()).isEqualTo(30_030(meter))
    }

    @Test
    fun `Measure has the correct equals and hashcode`() {
        val first = 10(Kilo.meter)
        val second = 10(Kilo.meter)
        assertThat(first == second && second == first)
        assertThat(first.hashCode() == second.hashCode())
    }
}