package com.example.measure

import com.example.measure.metrics.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigDecimal.ONE

class MeasureTest {

    @Test
    fun `Empty measure is correctly detected`() {
        assertThat(0(meter).isEmpty()).isTrue()
    }

    @Test
    fun `A measure can be normalized`() {
        val normalized = 30(Kilo.meter).normalized()
        assertThat(normalized.value).isEqualTo(BigDecimal(30_000))
        assertThat(normalized.metric).isEqualTo(meter)
    }

    @Test
    fun `Two measures can be added`() {
        assertThat(2(meter) + 1(meter)).isEqualTo(3(meter))
    }

    @Test
    fun `Two measures can be subtracted`() {
        assertThat(2(meter) - 1(meter)).isEqualTo(1(meter))
    }

    @Test
    fun `A measure can be multiplied`() {
        assertThat(2(meter) * BigDecimal("10")).isEqualTo(20(meter))
    }

    @Test
    fun `A measure can be divided`() {
        assertThat(2(meter) / BigDecimal("100")).isEqualTo(0.02(meter))
    }

    @Test
    fun `A measure can be converted to a different multiplier`() {
        assertThat(30(Kilo.meter) `in` meter).isEqualTo(30_000(meter))
        assertThat(30_000(meter) `in` meter).isEqualTo(30(Kilo.meter))
    }

    @Test
    fun `A list of measures can be combined`() {
        val values = listOf(30(Kilo.meter), 30(meter))
        assertThat(values.combined()).isEqualTo(30_030(meter))
    }

    @Test
    fun `A list of measures can be reduced`() {
        val values = listOf(30(Kilo.meter), 30(meter))
        assertThat(values.reduced()).isEqualTo(29_970(meter))
    }

    @Test
    fun `compareTo is correctly implemented`() {
        assertThat(10(meter).compareTo(5(meter))).isEqualTo(1)
        assertThat(10(Milli.meter).compareTo(10(Milli.meter))).isEqualTo(0)
        assertThat(5(Kilo.meter).compareTo(10(Mega.meter))).isEqualTo(-1)
    }

    @Test
    fun `toString is correctly implemented`() {
        assertThat(10(meter).toString()).isEqualTo("10m")
        assertThat(10(Kilo.meter).toString()).isEqualTo("10km")
    }

    @Test
    fun `equals is correctly implemented`() {
        assertThat(10_000(meter) == 10(Kilo.meter)).isTrue()
        assertThat(10_000(meter) == 5(Kilo.meter)).isFalse()
    }

    @Test
    fun `BigDecimals can be used to instantiate a measure`() {
        val result = ONE(meter)
        assertThat(result.value).isEqualTo(ONE)
        assertThat(result.metric).isEqualTo(Base.meter)
    }

    @Test
    fun `Integers can be used to instantiate a measure`() {
        val result = 1(meter)
        assertThat(result.value.compareTo(ONE)).isEqualTo(0)
        assertThat(result.metric).isEqualTo(Base.meter)
    }

    @Test
    fun `Doubles can be used to instantiate a measure`() {
        val result = 1.0(meter)
        assertThat(result.value.compareTo(ONE)).isEqualTo(0)
        assertThat(result.metric).isEqualTo(Base.meter)
    }
}