package leetcode

import kotlin.test.assertEquals

fun main() {
    assertEquals("P", convert("P", 3))
    assertEquals("PA", convert("PA", 3))
    assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3))
    assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4))
}

fun convert(s: String, numRows: Int): String {
    return when (numRows) {
        0 -> ""
        1 -> s
        else -> {
            val rows = (0 until numRows).map { mutableListOf<Char>() }
            var inc = 1
            var prevChange = 0
            var rowInd = 0;
            s.indices.forEach {
                //println("${rowInd} ${s[it]}")
                rows[rowInd].add(s[it])
                if ((rowInd == numRows - 1 || rowInd == 0) && prevChange >= numRows-1) {
                    prevChange = 0
                    inc = -inc
                }
                prevChange++
                rowInd += inc
            }
            rows.joinToString(separator = "") { it.joinToString(separator = "") { it.toString() } }
        }
    }
}