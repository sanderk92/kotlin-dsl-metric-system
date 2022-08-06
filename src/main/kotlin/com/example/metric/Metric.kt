package com.example.metric

class Weight(multiplier: UnitMultiplier) : Unit<Weight>(multiplier, "g") {
    override fun adjustMultiplier(multiplier: UnitMultiplier) = Weight(multiplier)
}

class Volume(multiplier: UnitMultiplier) : Unit<Volume>(multiplier, "l"){
    override fun adjustMultiplier(multiplier: UnitMultiplier) = Volume(multiplier)
}

class Distance(multiplier: UnitMultiplier) : Unit<Distance>(multiplier, "m"){
    override fun adjustMultiplier(multiplier: UnitMultiplier) = Distance(multiplier)
}

class Power(multiplier: UnitMultiplier) : Unit<Power>(multiplier, "W"){
    override fun adjustMultiplier(multiplier: UnitMultiplier) = Power(multiplier)
}

fun UnitMultiplier.gram() = Weight(this)
fun UnitMultiplier.liter() = Volume(this)
fun UnitMultiplier.meter() = Distance(this)
fun UnitMultiplier.watt() = Distance(this)