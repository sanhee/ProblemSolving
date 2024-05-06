package com.example.codility.training.arrays

class CyclicRotation

fun solution(A: IntArray, K: Int): IntArray {
    var result: IntArray = A.clone()

    for (i in 1..K) {
        result = rightRotate(result)
    }

    return result
}

private fun rightRotate(A: IntArray): IntArray {
    val B = IntArray(A.size)

    for (index in A.indices) {
        if (index != A.size - 1) {
            B[index + 1] = A[index]
        } else {
            B[0] = A[A.size - 1]
        }
    }

    return B
}

fun main() {
    solution(A = intArrayOf(3, 8, 9, 7, 6), K = 3)
}
