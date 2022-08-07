package com.example.measure.metric

class Weight(multiplier: UnitMultiplier) : Unit<Weight>(multiplier, multiplier.prefix + "g") {
    override fun normalize() = Weight(Base)
}

class Volume(multiplier: UnitMultiplier) : Unit<Volume>(multiplier, multiplier.prefix + "l") {
    override fun normalize() = Volume(Base)
}

class Length(multiplier: UnitMultiplier) : Unit<Length>(multiplier, multiplier.prefix + "m") {
    override fun normalize() = Length(Base)
}

class Power(multiplier: UnitMultiplier) : Unit<Power>(multiplier, multiplier.prefix + "W") {
    override fun normalize() = Power(Base)
}

fun UnitMultiplier.gram(): Unit<Weight> = Weight(this)
fun UnitMultiplier.liter(): Unit<Volume> = Volume(this)
fun UnitMultiplier.meter(): Unit<Length> = Length(this)
fun UnitMultiplier.watt(): Unit<Power> = Power(this)