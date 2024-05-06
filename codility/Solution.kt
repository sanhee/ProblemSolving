package com.example.codility

class Solution

fun solution(A: IntArray): Int {
    if (A.all { it < 0 }) {
        return 1
    }

    A.distinct()
    A.sortedArray()

    val size = A.size

    var result: Int = 1

    // 1 2 3 4 6
    for (i in 0..(size - 1)) {
        if (A[i] != i + 1) {
            return i + 1
        }
    }

    return A[size - 1] + 1
}

fun main() {
    // print(solution(A = intArrayOf(1, 2, 3)))
    print(solution(A = intArrayOf(1, 3, 6, 4, 1, 2))) // 5
}
