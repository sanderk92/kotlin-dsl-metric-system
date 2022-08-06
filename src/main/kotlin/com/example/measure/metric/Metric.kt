package com.example.measure.metric

class Weight(multiplier: UnitMultiplier) : Unit<Weight>(multiplier, "g") {
    override fun normalize() = Weight(Base)
}

class Volume(multiplier: UnitMultiplier) : Unit<Volume>(multiplier, "l"){
    override fun normalize() = Volume(Base)
}

class Length(multiplier: UnitMultiplier) : Unit<Length>(multiplier, "m"){
    override fun normalize() = Length(Base)
}

class Power(multiplier: UnitMultiplier) : Unit<Power>(multiplier, "W"){
    override fun normalize() = Power(Base)
}

fun UnitMultiplier.gram() = Weight(this)
fun UnitMultiplier.liter() = Volume(this)
fun UnitMultiplier.meter() = Length(this)
fun UnitMultiplier.watt() = Power(this)