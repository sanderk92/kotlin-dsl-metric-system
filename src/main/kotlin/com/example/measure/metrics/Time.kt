package com.example.measure.metrics

import com.example.measure.Base
import com.example.measure.Metric
import com.example.measure.MetricMultiplier
import java.math.BigDecimal

data class Time(override val multiplier: TimeMultiplier) : Metric<Time>(multiplier, multiplier.suffix) {
    override fun normalize() = Time(Seconds(Base))
    override fun toString() = "${multiplier.prefix}$suffix"
}

abstract class TimeMultiplier(multiplier: MetricMultiplier, seconds: BigDecimal, val suffix: String) :
    MetricMultiplier(multiplier.factor * seconds, multiplier.prefix)

class Seconds(multiplier: MetricMultiplier) : TimeMultiplier(multiplier, BigDecimal(1), "sec")
class Minutes(multiplier: MetricMultiplier) : TimeMultiplier(multiplier, BigDecimal(60), "min")
class Hours(multiplier: MetricMultiplier) : TimeMultiplier(multiplier, BigDecimal(3600), "hour")
class Days(multiplier: MetricMultiplier) : TimeMultiplier(multiplier, BigDecimal(86400), "day")

val MetricMultiplier.second: Metric<Time> get() = Time(Seconds(this))
val MetricMultiplier.minute: Metric<Time> get() = Time(Minutes(this))
val MetricMultiplier.hour: Metric<Time> get() = Time(Hours(this))
val MetricMultiplier.day: Metric<Time> get() = Time(Days(this))

val second: Metric<Time> = Time(Seconds(Base))
val minute: Metric<Time> = Time(Minutes(Base))
val hour: Metric<Time> = Time(Hours(Base))
val day: Metric<Time> = Time(Days(Base))