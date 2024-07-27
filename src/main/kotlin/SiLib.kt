package de.m4rv00

import kotlin.math.abs

class SiLib {
    companion object {
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

        fun Double?.unit(unit: Unit, precision: Int): String {
            if (this == null) {
                return ""
            }

            val prefix = Prefix.entries.toTypedArray().findLast { abs(this) >= it.factor } ?: Prefix.NONE

            return String.format("%.${precision}f %s%s", this / prefix.factor, prefix.symbol, unit.symbol)
        }
    }
}