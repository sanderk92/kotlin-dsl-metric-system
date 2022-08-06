package com.example.metric

import java.math.BigDecimal

// TODO is it okay to always adjustMultiplier to Time(Seconds(..))?
// TODO Fix prefix/suffix chaos

class Time(multiplier: TimeMultiplier) : Unit<Time>(multiplier, multiplier.prefix) {
    override fun adjustMultiplier(multiplier: UnitMultiplier) = Time(Seconds(multiplier))
}

abstract class TimeMultiplier(multiplier: UnitMultiplier, seconds: BigDecimal, suffix: String) :
    UnitMultiplier(multiplier.factor * seconds, multiplier.prefix + suffix)

class Seconds(unitMultiplier: UnitMultiplier) : TimeMultiplier(unitMultiplier, BigDecimal(1), "sec")
class Minutes(unitMultiplier: UnitMultiplier) : TimeMultiplier(unitMultiplier, BigDecimal(60), "min")
class Hours(unitMultiplier: UnitMultiplier) : TimeMultiplier(unitMultiplier, BigDecimal(3600), "hour")
class Days(unitMultiplier: UnitMultiplier) : TimeMultiplier(unitMultiplier, BigDecimal(86400), "day")

fun UnitMultiplier.second() = Time(Seconds(this))
fun UnitMultiplier.minute() = Time(Minutes(this))
fun UnitMultiplier.hour() = Time(Hours(this))
fun UnitMultiplier.day() = Time(Days(this))