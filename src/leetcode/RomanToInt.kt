package leetcode

import kotlin.test.assertEquals

fun main() {
    assertEquals(3, romanToInt("III"))
    assertEquals(4, romanToInt("IV"))
    assertEquals(9, romanToInt("IX"))
    assertEquals(58, romanToInt("LVIII"))
    assertEquals(1994, romanToInt("MCMXCIV"))
}

fun romanToInt(s: String): Int {

    val values = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

    var result = 0 //positives only...
    for (i in s.indices) {
        if (i < s.length - 1 && values[s[i]]!! < values[s[i + 1]]!!) result -= values[s[i]]!!
        else result += values[s[i]]!!
    }
    return result
}