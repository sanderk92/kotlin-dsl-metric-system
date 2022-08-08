package com.example

import com.example.measure.*
import com.example.measure.metric.*
import com.example.measure.metric.Kilo
import com.example.measure.metric.Nano
import org.junit.jupiter.api.Test

class Examples {

    @Test
    fun name() {
        val tenLiter = 10 of liter()
        val tenMeter = 10 of meter()
        val tenGram = 10 of gram()
        val tenWatt = 10 of watt()
        val tenSeconds = 10 of second()
        val tenMinutes = 10 of minute()
        val tenHours = 10 of hour()
        val tenDays = 10 of day()

        val tenKiloMeter = 10 of Kilo.meter()
        val temFemtoLiter = 10 of Femto.liter()
        val tenNanoGram = 10 of Nano.gram()

        val tenGramPerLiter = 10 of gram() per liter()
        val tenMeterPerSecond = 10 of meter() per second()
        val tenNanoGramPerLiter = 10 of Nano.gram() per liter()
        val tenKiloMeterPerHour = 10 of Kilo.meter() per hour()

        val tenKilometerPerTenDays = tenKiloMeter per tenDays
        val tenWattPerTenMinutes = tenWatt per tenMinutes

        val tenKilometerTimesFour = tenKiloMeter * 4
        val tenDaysDividedByFour = tenDays / 4

        val tenLiterMinusTenFemtoLiter = tenLiter - temFemtoLiter
        val tenSecondsPlusTenMinutes = tenSeconds + tenMinutes

        val tenGramPerLiterDividedByFour = tenGramPerLiter / 4

        val tenKilometerConvertedMeter = tenKiloMeter convertedTo meter()
        val tenLiterConvertedToNanoLiter = tenLiter convertedTo Nano.liter()

        println("done")
    }
}