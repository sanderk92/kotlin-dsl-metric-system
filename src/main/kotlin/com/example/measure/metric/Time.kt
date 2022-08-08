package com.example.measure.metric

import java.math.BigDecimal

class Time(multiplier: TimeMultiplier) : Metric<Time>(multiplier, multiplier.suffix) {
    override fun normalize() = Time(Seconds(Base))
}

abstract class TimeMultiplier(multiplier: MetricMultiplier, seconds: BigDecimal, val suffix: String) :
    MetricMultiplier(multiplier.factor * seconds, multiplier.prefix)

class Seconds(multiplier: MetricMultiplier) : TimeMultiplier(multiplier, BigDecimal(1), "sec")
class Minutes(multiplier: MetricMultiplier) : TimeMultiplier(multiplier, BigDecimal(60), "min")
class Hours(multiplier: MetricMultiplier) : TimeMultiplier(multiplier, BigDecimal(3600), "hour")
class Days(multiplier: MetricMultiplier) : TimeMultiplier(multiplier, BigDecimal(86400), "day")

fun MetricMultiplier.second(): Metric<Time> = Time(Seconds(this))
fun MetricMultiplier.minute(): Metric<Time> = Time(Minutes(this))
fun MetricMultiplier.hour(): Metric<Time> = Time(Hours(this))
fun MetricMultiplier.day(): Metric<Time> = Time(Days(this))

fun second(): Metric<Time> = Time(Seconds(Base))
fun minute(): Metric<Time> = Time(Minutes(Base))
fun hour(): Metric<Time> = Time(Hours(Base))
fun day(): Metric<Time> = Time(Days(Base))