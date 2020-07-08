package leetcode

import kotlin.test.assertEquals

fun main() {
    assertEquals(43422, reverse(22434))
    assertEquals(1, reverse(1))
    assertEquals(0, reverse(0))
    assertEquals(987654321, reverse(123456789))
    assertEquals(-321, reverse(-123))
    assertEquals(0, reverse(1534236469))
    assertEquals(0, reverse(-1534236469))
}

fun reverse(x: Int): Int {
    var current = x
    var result = 0;
    while (current != 0) {
        if (result > Int.MAX_VALUE / 10 || result < Int.MIN_VALUE / 10) return 0
        result = 10 * result + current % 10
        current /= 10
    }
    return result
}
