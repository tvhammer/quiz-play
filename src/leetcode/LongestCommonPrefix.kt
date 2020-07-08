package leetcode

import kotlin.test.assertEquals

fun main() {
    assertEquals("fl", longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    assertEquals("", longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    assertEquals("c", longestCommonPrefix(arrayOf("c", "c")))
    assertEquals("", longestCommonPrefix(arrayOf()))
}

fun longestCommonPrefix(strs: Array<String>): String {
    return if (strs.isEmpty()) ""
    else strs.reduce { acc, it ->

        var sub = ""
        for (i in (acc.length downTo 0)) {
            sub = acc.substring(0, i)
            if (it.startsWith(sub)) break
        }
        sub
    }
}