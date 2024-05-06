package com.example.codility.training.arrays

class OddOccurrencesInArray

fun solution(A: IntArray): Int {
    // return method1(A)

    return method2(A)
}

private fun method2(A: IntArray): Int {
    return A.reduce { total, num -> total xor num }
}

private fun method1(A: IntArray): Int {
    A.sort()
    var result = 0

    for (i in A.indices) {
        if (i.isEven()) {
            result += A[i]
        } else {
            result -= A[i]
        }
    }
    return result
}

private fun Int.isEven(): Boolean {
    return this % 2 == 0
}

fun main() {
    println(solution(A = intArrayOf(1,2,1)))
}
