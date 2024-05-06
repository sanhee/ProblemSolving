package com.example.BOJ.이분탐색.두용액

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays
import kotlin.math.abs

class SolutionKt

var N = 0
lateinit var numbers: IntArray
var result1 = 0
var result2 = 0

fun input() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    numbers = br.readLine().split(" ")
        .map { it.toInt() }.toIntArray()
}

fun lowerBound(values: IntArray, left: Int, right: Int, target: Int): Int {
    var index = right
    var L = left
    var R = right

    while (L <= R) {
        val middle = (L + R) / 2
        if (values[middle] >= target) {
            index = middle
            R = middle - 1
        } else {
            L = middle + 1
        }
    }
    return index
}

fun main() {
    input()
    Arrays.sort(numbers)

    var sum = Integer.MAX_VALUE

    for (idx in numbers.indices) {
        val findIdx = lowerBound(
            values = numbers,
            left = idx,
            right = N - 1,
            target = -numbers[idx],
        )

        if (findIdx > idx && findIdx < N &&
            abs(numbers[idx] + numbers[findIdx]) < sum
        ) {
            sum = abs(numbers[idx] + numbers[findIdx])
            result1 = numbers[idx]
            result2 = numbers[findIdx]
        }
    }
}
