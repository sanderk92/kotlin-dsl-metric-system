package com.example

import com.example.measure.*
import com.example.measure.metric.*
import com.example.measure.metric.Kilo
import com.example.measure.metric.Milli
import com.example.measure.metric.Nano
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun name() {
        val oneLiter = liter()
        val oneMeter = meter()
        val oneGram = gram()
        val oneWatt = watt()
        val oneSecond = second()
        val oneMinute = minute()
        val oneHour = hour()
        val oneDay = day()

        val tenLiter = 10.liter()
        val tenMeter = 10.meter()
        val tenGram = 10.gram()
        val tenWatt = 10.watt()
        val tenSeconds = 10.seconds()
        val tenMinutes = 10.minutes()
        val tenHours = 10.hours()
        val tenDays = 10.days()

        val tenKiloMeter = 10.kilometer()
        val tenMilliLiter = 10.milliliter()
        val tenNanoGram = 10 of Nano.gram()

        val tenKiloMeterPerTenMinutes = 10 of Kilo.meter() per 10.minutes()
        val tenNanoGramPerLiter = 10 of Nano.gram() per liter()
        val tenLiterPerHour = 10.liter() per hour()
        val oneMeterPerHour = meter() per hour()
        val oneKiloHour = 1 of Kilo.hour()

        val tenKilometerTimesFour = tenKiloMeter * 4
        val tenKilometerDividedByFour = tenKiloMeter / 4

        val tenKiloMeterPlusTenMeter = tenKiloMeter + tenMeter
        val oneLiterMinusTenFemtoLiter = oneLiter - tenMilliLiter
        val tenSecondsPlusOneMinute = tenSeconds + oneMinute
        val oneDayPlusOneMinute = oneDay + oneMinute

        val tenLiterPerHourDividedByFour = tenLiterPerHour / 4

        val tenKilometerConvertedToFemtoMeter = tenKiloMeter convertedTo Milli.meter()
        val tenMilliLiterConvertedToLiter = tenMilliLiter convertedTo Kilo.liter()
        val tenSecondsConvertedToKiloMinutes = tenSeconds convertedTo Kilo.minute()

        println("done")
    }
}