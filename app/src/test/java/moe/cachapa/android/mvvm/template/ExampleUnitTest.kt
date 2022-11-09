package moe.cachapa.android.mvvm.template

import org.junit.Test

import org.junit.Assert.*

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
}