package leetcode

import kotlin.test.assertEquals

fun main(){

    assertEquals(true, isPalindrome(121))
    assertEquals(false, isPalindrome(-121))
    assertEquals(true, isPalindrome(0))
    assertEquals(false, isPalindrome(2300))
    assertEquals(false, isPalindrome(Int.MAX_VALUE))
    assertEquals(false, isPalindrome(Int.MIN_VALUE))
    assertEquals(true, isPalindrome(1122332211))

}

fun isPalindrome(x: Int): Boolean {
    println(x)
    if(x < 0 ) return false
    if(x < 10) return true

    var digits = mutableListOf<Int>()
    var current = x
    while(current != 0){
        digits.add(current%10)
        current /=10
    }

    for(i in 0 until digits.size/2){
        if(digits[i] != digits[digits.size-1-i]) return false
    }
    return true
}