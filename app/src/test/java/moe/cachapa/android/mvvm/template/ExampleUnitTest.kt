package moe.cachapa.android.mvvm.template

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testSumDigits() {
        val number = 29

        val temp = number.toString()
        val charArray = temp.toCharArray()

        kotlin.test.assertTrue(charArray.size == 2)
    }

    @Test
    fun testBinaryGapString() {
        var intMaxValue: Int = 1800794937
        assert(intMaxValue >= 0)
        val binaryIntString = intMaxValue.toString(2) // Transform the integer to a binary string
        println(binaryIntString)
        val binaryStringArray =
            binaryIntString.toCharArray() // Transform the binary string to char array
        // Validate the number is zero
        val firstOne: Int = binaryStringArray.indexOfFirst { value -> value == '1' }
        println("The position for the first 1 is $firstOne")
        assert(firstOne >= 0)
        var count: Int = 0
        val gapList: MutableList<Int> = mutableListOf()
        if (firstOne >= 0) {
            binaryStringArray.forEach { i ->
                if (i == '0') {
                    count++
                } else {
                    gapList.add(count)
                    count = 0
                }
            }
        }
        val gap = gapList.maxOrNull() ?: 0
        println(gap)
        println(gapList.toString())
    }

    @Test
    fun testBinaryGapBit() {
        var number = 1010102222
        // New Stuff
        number = number or number - 1
        var steps = 0
        while (number and number + 1 != 0) {
            number = number or (number ushr 1)
            steps++
        }
        println(steps)
    }
}
