package de.m4rv00

enum class Prefix(val symbol: String, val factor: Double) {
    YOCTO("y", 1e-24),
    ZEPTO("z", 1e-21),
    ATTO("a", 1e-18),
    FEMTO("f", 1e-15),
    PICO("p", 1e-12),
    NANO("n", 1e-9),
    MICRO("µ", 1e-6),
    MILLI("m", 1e-3),
    NONE("", 1e0),
    KILO("k", 1e3),
    MEGA("M", 1e6),
    GIGA("G", 1e9),
    TERA("T", 1e12),
    PETA("P", 1e15),
    EXA("E", 1e18),
    ZETTA("Z", 1e21),
    YOTTA("Y", 1e24);
}