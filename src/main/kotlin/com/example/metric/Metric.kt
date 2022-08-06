package com.example.metric

class Weight(multiplier: UnitMultiplier) : Unit<Weight>(multiplier, "g") {
    override fun normalize() = Weight(Base)
}

class Volume(multiplier: UnitMultiplier) : Unit<Volume>(multiplier, "l"){
    override fun normalize() = Volume(Base)
}

class Distance(multiplier: UnitMultiplier) : Unit<Distance>(multiplier, "m"){
    override fun normalize() = Distance(Base)
}

class Power(multiplier: UnitMultiplier) : Unit<Power>(multiplier, "W"){
    override fun normalize() = Power(Base)
}

fun UnitMultiplier.gram() = Weight(this)
fun UnitMultiplier.liter() = Volume(this)
fun UnitMultiplier.meter() = Distance(this)
fun UnitMultiplier.watt() = Distance(this)