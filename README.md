# Kotlin Metric System DSL

An intuitive and easy to use Metric Unit DSL. 

```kotlin
// Instantiating a Measure (all supported types):
val volume: Measure<Volume> = 10(liter)
val length: Measure<Length> = 10(meter)
val mass: Measure<Mass> = 10(gram)
val power: Measure<Power> = 10(watt)
val byte: Measure<Byte> = 10(byte)
val seconds: Measure<Time> = 10(second)
val minutes: Measure<Time> = 10(minute)
val hours: Measure<Time> = 10(hour)
val days: Measure<Time> = 10(day)
val euro: Measure<Euro> = 10(euro)
val dollar: Measure<Dollar> = 10(dollar)

// Instantiating a Measure with a multiplier
val kilometer: Measure<Length> = 10(Kilo.meter)
val femtoLiter: Measure<Volume> = 10(Femto.liter)

// Basic operations on two Measures
val reduction1: Measure<Power> = 10(watt) - 10(Kilo.watt)
val addition1: Measure<Time> = 10(second) + 10(minute)

// Combining and reducing a list of Measures
val combined: Measure<Mass> = listOf(10(gram), 10(Kilo.gram)).combined()
val reduced: Measure<Byte> = listOf(10(Mega.byte), 10(Kilo.byte)).reduced()
val average: Measure<Volume> = listOf(10(liter), 10(Kilo.liter)).average()

// Converting the multiplier of Measures
val converted1 = 10(Kilo.meter) `in` meter
val converted2 = 10(liter) `in` Nano.liter

// Dynamic between two Measures
val dynamic1: Dynamic<Mass, Volume> = 10(Nano.gram) / liter
val dynamic2: Dynamic<Byte, Time> = 10(Giga.byte) / 2(hour)

// Dynamics often have type aliases
val speed: Speed = 10(Kilo.meter) / hour
val transferRate: TransferRate = 10(Mega.byte) / second

// Basic operations on Dynamics
val reduction: Speed = 10(Kilo.meter) / hour - 5(Kilo.meter) / hour
val addition: TransferRate = 10(Mega.byte) / hour + 10(byte) / minute
val multiplication: Measure<Mass> = 10(Nano.gram) / liter * 2(liter)

// Support for all numbers and complex calculations
val largeNumber = 10(Yotta.gram) / 10(Femto.meter) * 10(Yotta.meter) `in` Femto.gram
val smallNumber = 10(Femto.watt) / 10(Yotta.meter) * 10(Femto.meter) `in` Yotta.watt
```
