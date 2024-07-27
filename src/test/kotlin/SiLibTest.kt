import de.m4rv00.Prefix
import de.m4rv00.SiLib.Companion.si
import kotlin.test.Test
import kotlin.test.assertEquals

class SiLibTest {

    @Test
    fun testKiloPrefix() {
        // Int -> Double
        assertEquals(100_000.0, 100.si(Prefix.KILO))

        // Double -> Double
        assertEquals(100_000.0, 100.0.si(Prefix.KILO))

        // Float -> Double
        assertEquals(100_000.0, 100.0F.si(Prefix.KILO))

        assertEquals(1.0, 0.001.si(Prefix.KILO))
    }

    @Test
    fun testMegaPrefix() {
        // Int -> Double
        assertEquals(100_000_000.0, 100.si(Prefix.MEGA))

        // Double -> Double
        assertEquals(100_000_000.0, 100.0.si(Prefix.MEGA))

        // Float -> Double
        assertEquals(100_000_000.0, 100.0F.si(Prefix.MEGA))
    }

    @Test
    fun testMilliPrefix() {
        // Double -> Double
        assertEquals(0.1, 100.0.si(Prefix.MILLI))

        // Float -> Double
        assertEquals(0.1, 100.0F.si(Prefix.MILLI))
    }

    @Test
    fun testMicroPrefix() {
        // Combat rounding issues
        val tolerance = 0.000_000_1

        // Double -> Double
        assertEquals(0.000_100, 100.0.si(Prefix.MICRO), tolerance)

        // Float -> Double
        assertEquals(0.000_100, 100.0F.si(Prefix.MICRO), tolerance)
    }


    @Test
    fun testNonePrefix() {
        assertEquals(1.0, 1.si(Prefix.NONE))
        assertEquals(10.0, 10.si(Prefix.NONE))
        assertEquals(100.0, 100.si(Prefix.NONE))
    }
}