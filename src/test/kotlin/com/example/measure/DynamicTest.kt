package com.example.measure

import com.example.measure.metrics.hour
import com.example.measure.metrics.liter
import com.example.measure.metrics.meter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DynamicTest {

    @Test
    fun `A Measure can be divided by a Metric`() {
        val measure = 10(liter)

        val result = measure / liter

        assertThat(result.numerator).isEqualTo(measure)
        assertThat(result.denominator).isEqualTo(1(liter))
    }

    @Test
    fun `A Measure can be divided by a Measure`() {
        val measureOne = 10(liter)
        val measureTwo = 1(liter)

        val result = measureOne / measureTwo

        assertThat(result.numerator).isEqualTo(measureOne)
        assertThat(result.denominator).isEqualTo(measureTwo)
    }

    @Test
    fun `A Dynamic can be multiplied by a Measure`() {
        val dynamic = 10(liter) / hour
        val measure = 2(hour)

        val result = dynamic * measure

        assertThat(result).isEqualTo(20(liter))
    }

    @Test
    fun `Dynamic has the correct equals and hashcode`() {
        val first = 10(Kilo.meter) / hour
        val second = 10(Kilo.meter) / hour
        val third = 100(Hecto.meter) / hour

        assertThat(first == second && second == first)
        assertThat(first.hashCode() == second.hashCode())

        assertThat(first != third && third != first)
        assertThat(first.hashCode() != third.hashCode())
    }
}
