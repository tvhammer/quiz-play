package leetcode

import kotlin.test.assertEquals

fun main() {
    assertEquals(49, maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    assertEquals(16, maxArea(intArrayOf(1, 2, 5, 4, 3, 5, 4, 2)))
    assertEquals(8, maxArea(intArrayOf(1, 1, 1, 3, 4, 1, 1, 1, 1)))
    assertEquals(1, maxArea(intArrayOf(1, 1)))
    assertEquals(24, maxArea(intArrayOf(1, 3, 2, 5, 25, 24, 5)))
}

fun maxArea(height: IntArray): Int {
    var max = 0
    var left = 0
    var right = height.size - 1

    while (left != right) {
        val area = (right - left) * Math.min(height[left], height[right])
        max = if (area > max) area else max

        if (height[left] > height[right]) right--
        else left++
    }
    return max
}