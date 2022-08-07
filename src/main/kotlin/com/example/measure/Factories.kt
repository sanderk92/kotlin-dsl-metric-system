package com.example.measure

import com.example.measure.metric.*

/*
Factory methods for Measure of Weight
 */
fun milligram() = 1.milligram()
fun gram() = 1.gram()
fun kilogram() = 1.kilogram()

fun Number.milligram() = this of Milli.gram()
fun Number.gram() = this of Base.gram()
fun Number.kilogram() = this of Kilo.gram()

/*
Factory methods for Measure of Volume
 */
fun microliter() = 1.microliter()
fun milliliter() = 1.milliliter()
fun liter() = 1.liter()

fun Number.microliter() = this of Micro.liter()
fun Number.milliliter() = this of Milli.liter()
fun Number.liter() = this of Base.liter()

/*
Factory methods for Measure of Distance
 */
fun millimeter() = 1.millimeter()
fun meter() = 1.meter()
fun kilometer() = 1.kilometer()

fun Number.millimeter() = this of Milli.meter()
fun Number.meter() = this of Base.meter()
fun Number.kilometer() = this of Kilo.meter()

/*
Factory methods for Measure of Power
 */
fun milliWatt() = 1.milliWatt()
fun watt() = 1.watt()
fun kiloWatt() = 1.kiloWatt()
fun megaWatt() = 1.megaWatt()

fun Number.milliWatt() = this of Milli.watt()
fun Number.watt() = this of Base.watt()
fun Number.kiloWatt() = this of Kilo.watt()
fun Number.megaWatt() = this of Mega.watt()

/*
Factory methods for Measure of Time
 */
fun second() = 1.seconds()
fun minute() = 1.minutes()
fun hour() = 1.hours()
fun day() = 1.days()

fun Number.seconds() = this of Base.second()
fun Number.minutes() = this of Base.minute()
fun Number.hours() = this of Base.hour()
fun Number.days() = this of Base.day()

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
