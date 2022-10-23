package com.example.measure

import com.example.measure.metrics.*
import com.example.measure.metrics.Byte

typealias Speed = Dynamic<Length, Time>
typealias Energy = Dynamic<Power, Time>
typealias MassFlowRate = Dynamic<Mass, Time>
typealias VolumeFlowRate = Dynamic<Volume, Time>
typealias TransferRate = Dynamic<Byte, Time>

typealias PowerDensity = Dynamic<Power, Volume>
typealias MassConcentration = Dynamic<Mass, Volume>
typealias VolumeConcentration = Dynamic<Volume, Volume>
