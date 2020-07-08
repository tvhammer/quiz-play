package leetcode

import java.util.*
import kotlin.test.assertEquals

fun main() {
    assertEquals("III", intToRoman(3))
    assertEquals("IV", intToRoman(4))
    assertEquals("VI", intToRoman(6))
    assertEquals("VIII", intToRoman(8))
    assertEquals("IX", intToRoman(9))
    assertEquals("X", intToRoman(10))
    assertEquals("XII", intToRoman(12))
    assertEquals("XCV", intToRoman(95))
    assertEquals("CXXXVI", intToRoman(136))
    assertEquals("CXLVI", intToRoman(146))
    assertEquals("MMCDXVIII", intToRoman(2418))
}

fun intToRoman(num: Int): String {

    val letters = arrayOf(arrayOf('I', 'V', 'X'), arrayOf('X', 'L', 'C'), arrayOf('C', 'D', 'M'), arrayOf('M'))
    val romanNums = mutableListOf<Char>()
    var current = num;
    for (l in letters) {

        when (val last = current % 10) {
            in 1..3 -> repeat((0 until last).count()) { romanNums.add(l[0]) }
            4 -> arrayOf(l[1], l[0]).forEach { romanNums.add(it) }
            5 -> romanNums.add(l[1])
            in (6..8) -> {
                repeat((0 until last - 5).count()) { romanNums.add(l[0]) }
                romanNums.add(l[1])
            }
            9 -> arrayOf(l[2], l[0]).forEach { romanNums.add(it) }
        }
        current /= 10
    }
    romanNums.reverse()
    return romanNums.joinToString("")
}