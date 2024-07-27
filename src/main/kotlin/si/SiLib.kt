package de.m4rv00.si

import kotlin.math.abs

class SiLib {
    companion object {

        /**
         * Apply SI prefix scaling to any Number type.
         *
         * 100.si(Prefix.KILO) -> 100_000
         * 15.si(Prefix.NANO) -> 0.000_000_015
         *
         * @param prefix the SI prefix to apply, defaults to NONE which has a factor of 1.0.
         * @return the scaled number as a Double.
         * @throws IllegalArgumentException if the type T is not supported.
         */
        inline fun <reified T : Number?> T.si(prefix: Prefix = Prefix.NONE): Double {
            return when (this) {
                is Int -> (this.toDouble() * prefix.factor)
                is Float -> this.toDouble() * prefix.factor
                is Double -> this * prefix.factor
                else -> {
                    throw IllegalArgumentException("$this is not a number")
                }
            }
        }

        /**
         * Extension function for Double? to format it as a string with a unit and SI prefix.
         * 100_000 m -> 100 km
         * 0.1 s -> 100 ms
         *
         * @param unit the physical unit to append to the number after scaling.
         * @param precision the number of decimal places in output
         * @return a formatted string representing the number with SI prefix and unit, or an empty string if the number is null.
         */
        fun Double?.unit(unit: Unit, precision: Int): String {
            if (this == null) {
                return ""
            }

            // Find fitting prefix based on absolute magnitude of number
            val prefix = Prefix.entries.toTypedArray().findLast { abs(this) >= it.factor } ?: Prefix.NONE

            return String.format("%.${precision}f %s%s", this / prefix.factor, prefix.symbol, unit.symbol)
        }
    }
}