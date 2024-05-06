package com.example.BOJ.완전탐색.N과M_2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

var N = 0
var M = 0
var result = StringBuilder()
lateinit var selected: IntArray
lateinit var visited: BooleanArray

class SolutionKt

fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    selected = IntArray(M + 1)
    visited = BooleanArray(N + 1)
}

fun recFunc(column: Int) {
    if (column == M + 1) {
        selected.indices
            .filter { it > 0 }
            .forEach { result.append("${selected[it]} ") }
        result.append("\n")
    } else {
        val preNumber = selected[column - 1]
        val startNumber = if (preNumber == 0) {
            1
        } else {
            preNumber
        }

        for (num in startNumber..N) {
            if (!visited[num]) {
                selected[column] = num
                visited[num] = true
                recFunc(column = column + 1)
                visited[num] = false
            }
        }
    }
}

fun main() {
    init()
    recFunc(1)
    print(result.toString())
}
