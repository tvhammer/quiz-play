package leetcode

import kotlin.test.assertEquals

fun main() {

    assertEquals(5, myAtoi("5"))
    assertEquals(5, myAtoi("+5"))
    assertEquals(-5, myAtoi("-5"))
    assertEquals(5, myAtoi("   5"))
    assertEquals(-5, myAtoi("   -5"))
    assertEquals(2147483647, myAtoi("   +2147483647fsdf"))
    assertEquals(-2147483648, myAtoi("   -2147483648fsdf"))
    assertEquals(2147483647, myAtoi("   +921474836474533"))
    assertEquals(-2147483648, myAtoi("   -921474836484533"))
    assertEquals(0, myAtoi("   +ff334"))
    assertEquals(0, myAtoi("   "))
    assertEquals(0, myAtoi(""))
    assertEquals(0, myAtoi("+-2"))

}

fun myAtoi(str: String): Int {
    val pattern = "\\ *([+-]?\\d+).*"
    val regex = Regex(pattern)
    val matchRes = regex.matchEntire(str)
    if (matchRes != null) {
        var num = matchRes.groupValues[1]
        return try {
            num.toInt()
        } catch (e: NumberFormatException) {
            if(num.startsWith('-')) Int.MIN_VALUE
            else Int.MAX_VALUE
        }
    }
    return 0
}