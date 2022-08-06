package com.example.measure

import com.example.measure.metric.Base
import com.example.measure.metric.Kilo
import com.example.measure.metric.meter

/*
Factory methods for Measure of Speed
 */
fun Number.kilometerPerHour() = this of Kilo.meter() per hour()
fun Number.meterPerSecond() = this of Base.meter() per second()

/*
Factory methods for Measure of Volumetric Flow Rate
 */
fun Number.literPerHour() = this.liter() per hour()
fun Number.literPerSecond() = this.liter() per second()

/*
Factory methods for Measure of Mass Flow Rate
 */
fun Number.kilogramPerHour() = this.kilogram() per hour()
fun Number.kilogramPerSecond() = this.kilogram() per second()
