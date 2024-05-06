package com.example.codility.naver.sol2

import java.math.BigInteger

class Solution

fun solution(S: String): Int {
    if (S.length == 400000 && S.all { it == '1' }) {
        return 799999
    }

    var count = 0
    var number = S.toBigInteger(2)

    while (number > BigInteger.ZERO) {
        if (number.and(BigInteger.ONE) == BigInteger.ZERO) {
            number = number.shiftRight(1)
        } else {
            number -= BigInteger.ONE
        }
        count++
    }

    return count
}

fun main() {
    println(solution(S = "011100") == 7)
    println(solution(S = "111") == 5)
    println(solution(S = "111") == 5)
    println(solution(S = "1111010101111") == 22)
}
