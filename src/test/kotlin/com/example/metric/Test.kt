package com.example.metric

import org.junit.jupiter.api.Test

class Test {

    @Test
    fun name() {
        val oneLiter = liter()
        val oneMeter = meter()
        val oneGram = gram()
        val oneSecond = second()

        val tenFemtoGram = 10 of Femto.gram()
        val tenKilometerPerHour = 10 of Kilo.meter() per hour()
    }
}