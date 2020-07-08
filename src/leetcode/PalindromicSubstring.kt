package leetcode

import kotlin.test.assertEquals

fun main() {
    assertEquals("ada", longestPalindrome("labadasi"))
    assertEquals("", longestPalindrome(""))
    assertEquals("a", longestPalindrome("a"))
    assertEquals("aaaaaaaaaa", longestPalindrome("dsrtaaaaaaaaaaoiuyt"))
    assertEquals(
        "indulagorogaludni",
        longestPalindrome("labadasihhsfisdfjsdfuaflhpnlrgdkodf,sdfjcvjkfsdfofjnvicjdfpqsjfksdjflskdj,.nfjdlsjrtiwdsjfmfwfoij45knwefkdvnviwedfwejwelpqkfnvygt9rjfhvuffhfismdovjmegfyrjgnfdhfgjdjshgfjsnhfjkdhfjdbsbvmnsbdfmnsdbfiwuerhlmxcnajksindulagorogaludnilwodhfbfhfifjfflf-rf[dmfjdjfnbvbgchxcjfndgzhsy465u3ehdfjshbbvitlk,nmagheurmgkldlvpgoyiruejcnvbldkdigjghtyrughvbjvkxlspdfogjtyrhfjvowoe04lorkigerlfhsjhsbvbcvjdjsldfkgjeritjergusdhvnwerwe;wrwepdfghtertyytbdfu235n2345oifgjdfggfgndfgm45yp4o5y4rtrgtertopuembmbkbkb")
    )
}

fun longestPalindrome(s: String): String {
    if (s.equals("")) return ""

    val charMap = mutableMapOf<Char, MutableList<Int>>()
    s.forEachIndexed { ind, it ->
        if (!charMap.containsKey(it)) charMap[it] = mutableListOf(ind) else charMap[it]!!.add(ind)
    }

    var max = 1
    var string = s.substring(0, 1)
    charMap.keys.forEach {
        val list = charMap[it]!!
        if (list.size != 1) {
            (0 until list.size).forEach { i ->
                (i + 1 until list.size).forEach { j ->
                    if (list[j] - list[i] >= max) {
                        val length = list[j] - list[i]
                        var match = true
                        var k = 0
                        while(match && k<=length/2) {
                            if(s[list[i]+k] != s[list[j]-k]) {
                                match = false
                                break
                            }
                            k++
                        }
                        if(match){
                            max = length
                            string = s.substring(list[i], list[j] + 1)
                        }
                    }
                }
            }
        }
    }
    return string
}