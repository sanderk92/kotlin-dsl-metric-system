# Kotlin Metric System DSL

An intuitive and easy to use Metric Unit DSL. 

```kotlin
// Instantiating a Measure (all supported types):
val measure1: Measure<Volume> = 10(liter)
val measure2: Measure<Length> = 10(meter)
val measure3: Measure<Mass> = 10(gram)
val measure4: Measure<Power> = 10(watt)
val measure5: Measure<Byte> = 10(byte)
val measure6: Measure<Time> = 10(second)
val measure7: Measure<Time> = 10(minute)
val measure8: Measure<Time> = 10(hour)
val measure9: Measure<Time> = 10(day)

// Instantiating a Measure with a multiplier
val measure10: Measure<Length> = 10(Kilo.meter)
val measure11: Measure<Volume> = 10(Femto.liter)

// Basic operations on two Measures
val reduction: Measure<Power> = 10(watt) - 10(Kilo.watt)
val addition: Measure<Time> = 10(second) + 10(minute)

// Combining and reducing a list of Measures
val combined = listOf(10(gram), 10(Kilo.gram)).combined()
val reduced = listOf(10(Mega.byte), 10(Kilo.byte)).reduced()

// Converting the multiplier of Measures
val converted1 = 10(Kilo.meter) convertedTo meter
val converted2 = 10(liter) convertedTo Nano.liter

// Dynamic between two Measures
val dynamic1: Dynamic<Mass, Volume> = 10(Nano.gram) / liter
val dynamic2: Dynamic<Byte, Time> = 10(Giga.byte) / 2(hour)

// Dynamics often have type aliases
val dynamic1: Speed = 10(Kilo.meter) / hour
val dynamic2: TransferRate = 10(Mega.byte) / second

// Basic operations on two Dynamics
val reduction: Speed = 10(Kilo.meter) / hour - 5(Kilo.meter) / hour
val addition: TransferRate = 10(Mega.byte) / hour + 10(byte) / minute

// Normalizing a Dynamic of two Measures by multiplying with a Measure
val dynamicNormalized1: Measure<Mass> = 10(Nano.gram) / liter * 2(liter)
val dynamicNormalized2: Measure<Length> = 10(meter) / day * 2(day)

// Support for all numbers and complex calculations
val largeNumber = 10(Yotta.gram) / 10(Femto.meter) * 10(Yotta.meter) convertedTo Femto.gram
val smallNumber = 10(Femto.watt) / 10(Yotta.meter) * 10(Femto.meter) convertedTo Yotta.watt
```
