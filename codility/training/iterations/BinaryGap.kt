package com.example.codility.training.iterations

class BinaryGap

fun solution(N: Int): Int {
    val binaryString: String = Integer.toBinaryString(N)
    val containsZero = binaryString.contains("0")
    val countOne = binaryString.count { it == '1' } == 1

    if (!containsZero || countOne) {
        return 0
    }

    var countOfOne = 0
    var countOfZero = 0

    val binaryGapLengthList = mutableListOf(0)

    for (char in binaryString) {
        if (char == '1') {
            countOfOne++
        }
        if (char == '0') {
            countOfZero++
        }

        if (countOfOne == 2) {
            binaryGapLengthList.add(countOfZero)

            countOfOne = 1
            countOfZero = 0
        }
    }
    binaryGapLengthList.sort()
    binaryGapLengthList.reverse()
    return binaryGapLengthList[0]
}

fun main() {
    // println("N= 1041, actual: ${solution(N = 1041)}, expect: 5, ${solution(N = 1041) == 5}")
    println("N= 32, actual: ${solution(N = 32)}, expect: 0, ${solution(N = 1041) == 0}")
}
