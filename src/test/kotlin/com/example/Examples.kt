package com.example

import com.example.measure.*
import com.example.measure.metric.*
import com.example.measure.metric.Kilo
import com.example.measure.metric.Nano
import org.junit.jupiter.api.Test

class Examples {

    @Test
    fun name() {
        val tenLiter = 10(liter)
        val tenMeter = 10(meter)
        val tenGram = 10(gram)
        val tenWatt = 10(watt)
        val tenSeconds = 10(second)
        val tenMinutes = 10(minute)
        val tenHours = 10(hour)
        val tenDays = 10(day)

        val tenKiloMeter = 10(Kilo.meter)
        val tenFemtoLiter = 10(Femto.liter)

        val tenWattMinusTenFemtoWatt = 10(watt) - 10(Kilo.watt)
        val tenSecondsPusTenMinutes = 10(second) + 10(minute)

        val tenNanoGramPerLiter = 10(Nano.gram) / liter
        val tenKiloWattPerHour = 10(Kilo.watt) / hour

        val tenNanoGramPerLiterTimesTwoLiter = 10(Nano.gram) / liter * 2(liter)
        val tenMeterPerSecondTimesTwoMinutes = 10(meter) / day * 2(day)

        val tenGramPlusTenKiloGram = listOf(10(gram), 10(Kilo.gram)).combined()
        val tenGramMinusTenKiloGram = listOf(10(gram), 10(Kilo.gram)).deducted()

        val tenKilometerConvertedMeter = tenKiloMeter convertTo meter
        val tenLiterConvertedToNanoLiter = tenLiter convertTo Nano.liter
    }
}