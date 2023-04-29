package com.example.measure

import com.example.measure.metrics.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class DynamicTest {

    @Test
    fun `Empty dynamic is correctly detected`() {
        assertThat((0(gram) / meter).isEmpty()).isTrue()
    }

    @Test
    fun `A dynamic can be normalized`() {
        val normalized = (30(Kilo.gram) / meter).normalized()
        assertThat(normalized.numerator.value).isEqualTo(BigDecimal(30_000))
        assertThat(normalized.numerator.metric).isEqualTo(gram)
        assertThat(normalized.denominator.value).isEqualTo(BigDecimal(1))
        assertThat(normalized.denominator.metric).isEqualTo(meter)
    }

    @Test
    fun `A dynamic can be added to another dynamic`() {
        assertThat(10(gram) / meter + 10(gram) / Kilo.meter).isEqualTo(10.010(gram) / meter)
    }

    @Test
    fun `A dynamic can be subtracted from another dynamic`() {
        assertThat(10(gram) / meter - 10(gram) / Kilo.meter).isEqualTo(9.990(gram) / meter)
    }

    @Test
    fun `A dynamic can be multiplied by a measure`() {
        assertThat(10(gram) / meter * 1(Kilo.meter)).isEqualTo(10_000(gram))
    }

    @Test
    fun `compareTo is correctly implemented`() {
        assertThat((10(meter) / gram).compareTo((5(Milli.meter) / gram))).isEqualTo(1)
        assertThat((10(meter) / gram).compareTo((10(meter) / gram))).isEqualTo(0)
        assertThat((10(meter) / gram).compareTo((1(Kilo.meter) / gram))).isEqualTo(-1)
    }

    @Test
    fun `toString is correctly implemented`() {
        assertThat((10(Kilo.meter) / gram).toString()).isEqualTo("10km / 1g")
    }

    @Test
    fun `equals is correctly implemented`() {
        assertThat(10_000(meter) / hour == 10(Kilo.meter) / hour).isTrue()
        assertThat(10_000(meter) / hour == 5(Kilo.meter) / hour).isFalse()
    }

    @Test
    fun `A measure and a metric can be used to instantiate a dynamic`() {
        val dynamic = 10(gram) / meter
        assertThat(dynamic.numerator).isEqualTo(10(gram))
        assertThat(dynamic.denominator).isEqualTo(1(meter))
    }

    @Test
    fun `A measure and another measure can be used to instantiate a dynamic`() {
        val dynamic = 10(gram) / 1(meter)
        assertThat(dynamic.numerator).isEqualTo(10(gram))
        assertThat(dynamic.denominator).isEqualTo(1(meter))
    }
}
