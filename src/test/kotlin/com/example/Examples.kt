package com.example

import com.example.measure.*
import com.example.measure.metric.*
import com.example.measure.metric.Kilo
import com.example.measure.metric.Nano
import org.junit.jupiter.api.Test

class Examples {

    @Test
    fun name() {
        val tenLiter = 10 of liter
        val tenMeter = 10 of meter
        val tenGram = 10 of gram
        val tenWatt = 10 of watt
        val tenSeconds = 10 of second
        val tenMinutes = 10 of minute
        val tenHours = 10 of hour
        val tenDays = 10 of day

        val tenKiloMeter = 10 of Kilo.meter
        val tenFemtoLiter = 10 of Femto.liter

        val tenLiterMinusTenFemtoLiter = (10 of liter) - (10 of Femto.liter)
        val tenSecondsPusTenMinutes = (10 of second) + (10 of minute)

        val tenNanoGramPerLiter = 10 of Nano.gram per liter
        val tenKiloWattPerHour = 10 of Kilo.watt per hour

        val tenNanoGramPerLiterTimesTwoLiter = (10 of Nano.gram per liter) * (2 of liter)
        val tenMeterPerSecondTimesTwoMinutes = (10 of meter per day) * (2 of day)

        val tenGramPlusTenKiloGram = listOf(10 of gram, 10 of Kilo.gram).combined()
        val tenGramMinusTenKiloGram = listOf(10 of gram, 10 of Kilo.gram).deducted()

        val tenKilometerConvertedMeter = tenKiloMeter convertTo meter
        val tenLiterConvertedToNanoLiter = tenLiter convertTo Nano.liter
    }
}