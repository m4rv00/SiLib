# SiLib - SI Unit Conversion Library

`SiLib` is a Kotlin library to scale numerical values with [SI](https://www.bipm.org/en/publications/si-brochure)
prefixes and format them with [SI](https://www.bipm.org/en/publications/si-brochure) base units

## Usage

```kotlin
import de.m4rv00.si.Prefix
import de.m4rv00.si.SiLib.Companion.si
import de.m4rv00.si.SiLib.Companion.unit
import de.m4rv00.si.Unit

fun main() {
    100.si(Prefix.KILO) // -> 100_000
    15.si(Prefix.NANO) // -> 0.000_000_015

    println(1.si(Prefix.KILO).unit(Unit.METER, 3)) // -> "1.000 km"
    println(1.7918.si(Prefix.MILLI).unit(Unit.SECOND, 3)) // -> "1.792 ms"
}
```

## License

Distributed under the [GNU General Public License v3.0 or later](https://spdx.org/licenses/GPL-3.0-or-later.html).
See [LICENSE](LICENSE.MD) for more information.



